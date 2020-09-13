package nl.novi.Sportsapp.repository;

import nl.novi.Sportsapp.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
