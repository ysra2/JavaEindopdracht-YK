package nl.novi.Sportsapp.repository;

import nl.novi.Sportsapp.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
 List<Activity> getActivitiesByActivityName(String activityName);

}
