package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.model.Trainer;
import nl.novi.Sportsapp.service.ActivityRepository;
import nl.novi.Sportsapp.service.SporterRepository;
import nl.novi.Sportsapp.service.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.transaction.TransactionalException;
import java.util.List;
import java.util.Optional;

@RestController //spring weet dan dat we met een restcontroller te maken hebben
public class TrainerController {

    @Autowired //deze wordt gekoppeld met de service klasse
    private TrainerRepository trainerRepository;

    @Autowired
    private SporterRepository sporterRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping(value = "/api/trainer/{trainerId}") //downloaden
    public Trainer getTrainer(@PathVariable Long trainerId) {
        Optional<Trainer> trainer = trainerRepository.findById(trainerId);
        if (trainer.isPresent()){
            return trainer.get();
        }
//        throw new TrainerNotFoundException("");
        return null;
//        return trainerRepository.findById(trainerId).orElseThrow(
//                () -> new TrainerNotFoundException(trainerId));

    }

    @GetMapping(value = "/api/dog")
    public List<Activity> getActivities() {
        List<Activity> activityList = activityRepository.findAll();
        return activityList;
    }

    @PostMapping(value = "/api/trainer") //localhost:8080/api/trainer // plaatsen
    public Trainer saveTrainer(@RequestBody Trainer newTrainer){
        return trainerRepository.save(newTrainer);
    }

    @DeleteMapping(value="/api/trainer/{trainerId}")
    public boolean deleteTrainer(@PathVariable long trainerId) {
        Optional<Trainer> trainer = trainerRepository.findById(trainerId);
        if (trainer.isPresent()) {
            trainerRepository.deleteById(trainerId);
            return true;
        }
        return false;
    }

    @PutMapping(value = "api/trainer/{trainerId}") //updaten, dit gaan gebruiken om trainingen te updaten (in tijd/datum)
    public Trainer updateTrainerById(@PathVariable long trainerId, @RequestBody Trainer updateTrainer){
        return trainerRepository.findById(trainerId).map(
                trainer -> {
                    trainer.setName(updateTrainer.getName());
                    trainer.setEmail(updateTrainer.getEmail());
                    return trainerRepository.save(trainer);
                })
                .orElseGet(() ->{
                        updateTrainer.setTrainId(trainerId);
                        return trainerRepository.save(updateTrainer);
                });
        }
     // activiteit kan niet bestaan als er geen personaltrainer is
    // activiteit toevoegen op basis van trainer
//        @PostMapping("api/trainer/{trainerID}/activity")
//        public Trainer addActivityToTrainer(@PathVariable long trainerId, @RequestBody Activity newActivity){
//        Optional<Trainer> trainer = trainerRepository.findById(trainerId);
//
//        if (trainer.isPresent()){
//            Trainer trainerFromDb = trainer.get();
//            List<Activity> currentAcivities = trainerFromDb.getActivities();
//
//            newActivity.setSporters(trainerFromDb);
//
//            currentAcivities.add(newActivity);
//            trainerFromDb.setActivities(currentAcivities);
//
//        }
//        return null;
//        }

}
