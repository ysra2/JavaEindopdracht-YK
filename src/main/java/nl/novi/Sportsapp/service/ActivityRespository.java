package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRespository extends JpaRepository<Activity, Long> {
}
