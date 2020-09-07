package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.model.Trainer;
import nl.novi.Sportsapp.service.ActivityRepository;
import nl.novi.Sportsapp.service.SporterRepository;
import nl.novi.Sportsapp.service.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController //sping weet dan dat we met een restcontroller te maken hebben
public class TrainerController {

    @Autowired //deze wordt gekoppeld met de service klasse
    private TrainerRepository trainerRepository;

    @Autowired
    private SporterRepository sporterRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping(value = "/api/trainer/{trainerId}")
    public Trainer getTrainer(@PathVariable Long activityId) {
        Optional<Trainer> trainer = trainerRepository.findById(activityId);
        if (trainer.isPresent()){
            return trainer.get();
        }
        return null;
    }

    @PostMapping(value = "/api/trainer") //localhost:8080/api/trainer
    public Trainer saveTrainer(@RequestBody Trainer newTrainer){
        return trainerRepository.save(newTrainer);
    }


//
//    @DeleteMapping
//
//    @PutMapping
}
