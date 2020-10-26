package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.dto.request.LoginRequest;
import nl.novi.Sportsapp.dto.request.SignupRequest;
import nl.novi.Sportsapp.dto.response.JwtResponse;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "http://localhost:3000"}, maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/signup") // registreren
    public ResponseEntity<MessageResponse> registerUser(@RequestBody SignupRequest signUpRequest) {
        return authenticationService.registerUser(signUpRequest);
    }


    @PostMapping("/signin") // inloggen
    public ResponseEntity<JwtResponse> authAppUserSport(@RequestBody LoginRequest loginRequest) {
        return authenticationService.authAppUserSport(loginRequest);
    }
}
