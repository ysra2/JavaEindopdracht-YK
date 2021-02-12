package nl.novi.Sportsapp.service.security.jwt;

import nl.novi.Sportsapp.dto.request.SignupRequest;
import nl.novi.Sportsapp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataBaseFillerRoles implements CommandLineRunner {
    private final AuthenticationService authenticationService;

    @Autowired
    DataBaseFillerRoles(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public void run(String... args) {

        Set<String> roles = new HashSet<>();
        roles.add("admin");
        roles.add("trainer");
        roles.add("sporter");

        SignupRequest admin = new SignupRequest();
        admin.setFirstname("admin");
        admin.setLastName("admin");
        admin.setUsername("admin");
        admin.setEmail("admin@admin.com");
        admin.setPassword("12345678");
        admin.setRole(roles);
        authenticationService.registerUser(admin);

        SignupRequest trainer = new SignupRequest();
        trainer.setFirstname("trainer");
        trainer.setLastName("trainer");
        trainer.setUsername("trainer");
        trainer.setEmail("trainer@trainer.com");
        trainer.setPassword("12345678");
        trainer.setRole(roles);
        authenticationService.registerUser(trainer);

        SignupRequest sporter = new SignupRequest();
        sporter.setFirstname("sporter");
        sporter.setLastName("sporter");
        sporter.setUsername("sporter");
        sporter.setEmail("sporter@sporter.com");
        sporter.setPassword("12345678");
        sporter.setRole(roles);
        authenticationService.registerUser(sporter);
    }

}
