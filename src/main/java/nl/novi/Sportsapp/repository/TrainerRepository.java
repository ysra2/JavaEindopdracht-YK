package nl.novi.Sportsapp.repository;

import nl.novi.Sportsapp.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}