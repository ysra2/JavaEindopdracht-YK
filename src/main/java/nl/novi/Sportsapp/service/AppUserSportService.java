package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.dto.request.LoginRequest;
import nl.novi.Sportsapp.dto.response.JwtResponse;
import nl.novi.Sportsapp.exception.UserSportNotFoundException;
import nl.novi.Sportsapp.model.AppUserSport;
import nl.novi.Sportsapp.repository.AppUserSportRepository;
import nl.novi.Sportsapp.service.security.jwt.JwtUtils;
import nl.novi.Sportsapp.service.userdetails.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Validated
public class AppUserSportService implements IAppUserSportService {


    @Autowired
    AppUserSportRepository appUserSportRepository;
    AuthenticationManager authenticationManager;
    JwtUtils jwtUtils;

    @Override
    @PreAuthorize("hasRole('TRAINER') or hasRole('SPORTER') or hasRole('ADMIN')")
    public ResponseEntity<JwtResponse> authAppUserSport(@Valid LoginRequest loginRequest) {
        //authenticate op basis van de email en password door middel van de usertoken authentication
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                    loginRequest.getPassword())
        );

        //opgehaald neergezet
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //token wordt aangemaakt
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
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
//
//    @PreAuthorize("hasRole('TRAINER') or hasRole('SPORTER') or hasRole('ADMIN')")
//    public ResponseEntity<MessageResponse> registerUser(@Valid SignupRequest signUpRequest) {
//        if (Boolean.TRUE.equals(appUserSportRepository.existsByUsername(signUpRequest.getUsername()))) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: Username is already taken!"));
//        }
//
//        if (Boolean.TRUE.equals(appUserSportRepository.existsByEmail(signUpRequest.getEmail()))) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: Email is already in use!"));
//        }
//
//        // Create new user's account
//        AppUserSport appUserSport = new AppUserSport(signUpRequest.getUsername(),
//                signUpRequest.getEmail(),
//                encoder.encode(signUpRequest.getPassword()));
//
//        Set<Role> strRoles = signUpRequest.getRole();
//        Set<Role> roles = new HashSet<>();
//
//        if (strRoles == null) {
//            Role userRole = roleRepository.findByName(ERole.ROLE_TRAINER)
//                    .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
//            roles.add(userRole);
//        } else {
//            strRoles.forEach(role -> {
//                switch (role) {
//                    case "admin":
//                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//                                .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
//                        roles.add(adminRole);
//
//                        break;
//                    case "sporter":
//                        Role adminRole = roleRepository.findByName(ERole.ROLE_SPORTER)
//                                .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
//                        roles.add(adminRole);
//
//                        break;
//
//                    case "trainer":
//                        Role modRole = roleRepository.findByName(ERole.ROLE_TRAINER)
//                                .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
//                        roles.add(modRole);
//
//                        break;
////                    default:
////                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
////                                .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
////                        roles.add(userRole);
//                }
//            });
//        }
//
//        appUserSport.setRoles(roles);
//        appUserSportRepository.save(appUserSport);
//
//        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//    }

    @PreAuthorize("hasRole('TRAINER')")
    @Override
    public List<AppUserSport> getTrainers() {
        List<AppUserSport> trainerList = appUserSportRepository.findAll();
        return trainerList;
    }

    @PreAuthorize("hasRole('TRAINER')")
    @Override
    public AppUserSport getTrainer(long id){
        return appUserSportRepository.findById(id).orElseThrow(
                () -> new UserSportNotFoundException(id));
    }

    @PreAuthorize("hasRole('TRAINER')")
    @Override
    public AppUserSport saveTrainer(AppUserSport newTrainer) {
        return appUserSportRepository.save(newTrainer);
    }

    @PreAuthorize("hasRole('TRAINER')")
    @Override
    public AppUserSport updateUserById(long id, AppUserSport updatedUserSport) {
        return appUserSportRepository.findById(id).map(
                user -> {
                    user.setUsername(updatedUserSport.getUsername());
                    user.setEmail(updatedUserSport.getEmail());
                    user.setPassword(updatedUserSport.getPassword());
                    return appUserSportRepository.save(user);
                })
                // Kan de user niet vinden in database
                .orElseGet(() -> {
                    return appUserSportRepository.save(updatedUserSport);
                });
    }

//    public AppUserSport addActivityToTrainer(long id,  Activity newActivity){
//        Optional<Activity> trainer = activityRepository.findById(id);
//
//        if (trainer.isPresent()){
//            AppUserSport trainerFromDb = trainer.get();
//            List<AppUserSport> currentActivities = trainerFromDb.getUserId();
//
//            newActivity.setActivityId(trainerFromDb);
//
//            currentActivities.add(newActivity);
//            trainerFromDb.setUserId((AppUserSport) currentActivities);
//
//        }
//        return null;
//    }

    @PreAuthorize("hasRole('TRAINER')")
    @Override
    public boolean deleteTrainer(long id){
    Optional<AppUserSport> trainer =appUserSportRepository.findById(id);
    if (trainer.isPresent()){
        appUserSportRepository.deleteById(id);
        return true;
    } else{
        return false;
    }
    }



}
