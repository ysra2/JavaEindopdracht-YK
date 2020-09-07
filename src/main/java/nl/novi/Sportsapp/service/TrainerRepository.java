package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}