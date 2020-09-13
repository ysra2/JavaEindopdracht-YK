package nl.novi.Sportsapp.repository;

import nl.novi.Sportsapp.model.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {
}
