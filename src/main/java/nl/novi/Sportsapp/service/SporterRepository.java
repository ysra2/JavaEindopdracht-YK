package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.model.Sporter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SporterRepository extends JpaRepository <Sporter, Long> {
}
