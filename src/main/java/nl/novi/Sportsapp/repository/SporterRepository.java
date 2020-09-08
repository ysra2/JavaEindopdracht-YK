package nl.novi.Sportsapp.repository;

import nl.novi.Sportsapp.model.Sporter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SporterRepository extends JpaRepository <Sporter, Long> {
}
