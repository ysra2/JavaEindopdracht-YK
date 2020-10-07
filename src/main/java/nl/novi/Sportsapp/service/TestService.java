package nl.novi.Sportsapp.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String generatePublicContent() {
        return "Public Content.";
    }

    @PreAuthorize("hasRole('SPORTER') or hasRole('TRAINER') or hasRole('ADMIN')")
    public String generateUserContent() {
        return "User Content.";
    }

    @PreAuthorize("hasRole('SPORTER')")
    public String generateSporterContent() {
        return "Admin Board.";
    }

    @PreAuthorize("hasRole('TRAINER')")
    public String generateTrainerContent() {
        return "Admin Board.";
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String generateAdminContent() {
        return "Admin Board.";
    }

}