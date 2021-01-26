package nl.novi.Sportsapp.service.security.jwt;

import nl.novi.Sportsapp.dto.request.SignupRequest;
import nl.novi.Sportsapp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataBaseFiller implements CommandLineRunner {
    private final AuthenticationService authenticationService;

    @Autowired
    DataBaseFiller(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public void run(String... args) {

        Set<String> roles = new HashSet<>();
        roles.add("admin");

        SignupRequest admin = new SignupRequest();
        admin.setFirstname("admin");
        admin.setLastName("admin");
        admin.setUsername("admin");
        admin.setEmail("admin@admin.com");
        admin.setPassword("12345678");
        admin.setRole(roles);
        authenticationService.registerUser(admin);
    }
}
