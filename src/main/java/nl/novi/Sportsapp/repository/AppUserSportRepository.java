package nl.novi.Sportsapp.repository;

import nl.novi.Sportsapp.model.AppUserSport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserSportRepository extends JpaRepository<AppUserSport, Long> {
    Optional<AppUserSport> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
