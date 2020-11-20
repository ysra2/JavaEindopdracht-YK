package nl.novi.Sportsapp.repository;

import nl.novi.Sportsapp.model.UserSports;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSportsRepository extends JpaRepository<UserSports, Long> {
    Optional<UserSports> findByEmail(String email);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
//    List<UserSports> getNameTrainer(String firstName);
}
