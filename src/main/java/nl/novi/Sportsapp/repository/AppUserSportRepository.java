package nl.novi.Sportsapp.repository;

import nl.novi.Sportsapp.model.AppUserSport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserSportRepository extends JpaRepository<AppUserSport, Long> {
}
