package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.dto.request.LoginRequest;
import nl.novi.Sportsapp.dto.request.SignupRequest;
import nl.novi.Sportsapp.dto.response.JwtResponse;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.AppUserSport;
import nl.novi.Sportsapp.model.ERole;
import nl.novi.Sportsapp.model.Role;
import nl.novi.Sportsapp.repository.AppUserSportRepository;
import nl.novi.Sportsapp.repository.RoleRepository;
import nl.novi.Sportsapp.service.appuserdetails.AppUserDetailsImpl;
import nl.novi.Sportsapp.service.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Validated
public class AuthenticationService {

    private static final String ROLE_NOT_FOUND_ERROR = "Error: Role is not found.";

    @Autowired
    AppUserSportRepository appUserSportRepository;
    AuthenticationManager authenticationManager;
    PasswordEncoder encoder;
    RoleRepository roleRepository;
    JwtUtils jwtUtils;

    @Autowired
    public void setAppUserRepository(AppUserSportRepository appUserSportRepository) {
        this.appUserSportRepository = appUserSportRepository;
    }

    @Autowired
    public void setEncoder(PasswordEncoder passwordEncoder) {
        this.encoder = passwordEncoder;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setJwtUtils(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    public ResponseEntity<MessageResponse> registerUser(@Valid SignupRequest signUpRequest) {
//        if (Boolean.TRUE.equals(appUserSportRepository.existsByUsername(signUpRequest.getUsername()))) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: Username is already taken!"));
//        }

        if (Boolean.TRUE.equals(appUserSportRepository.existsByEmail(signUpRequest.getEmail()))) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        AppUserSport appUserSport = new AppUserSport(
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_TRAINER)
                    .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
                        roles.add(adminRole);

                        break;
                    case "sporter":
                        Role sporterRole = roleRepository.findByName(ERole.ROLE_SPORTER)
                                .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
                        roles.add(sporterRole);

                        break;
                    default:
                    case "trainer":
                        Role trainerRole = roleRepository.findByName(ERole.ROLE_TRAINER)
                                .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
                        roles.add(trainerRole);


                }
            });
        }

        appUserSport.setRoles(roles);
        appUserSportRepository.save(appUserSport);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }


    public ResponseEntity<JwtResponse> authAppUserSport(@Valid LoginRequest loginRequest) {
        //authenticate op basis van de email en password door middel van de usertoken authentication
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword())
                );

        //opgehaald neergezet
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //token wordt aangemaakt
        String jwt = jwtUtils.generateJwtToken(authentication);

        AppUserDetailsImpl userDetails = (AppUserDetailsImpl) authentication.getPrincipal();
        //voegt de rol toe
        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        //geeft terug aan response entity
        //status ok is 202 in postman
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getEmail(),
                userDetails.getPassword(),
                roles
        ));
    }





}
