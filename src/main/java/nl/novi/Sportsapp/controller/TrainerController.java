package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.model.Trainer;
import nl.novi.Sportsapp.service.ActivityService;
import nl.novi.Sportsapp.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//Single responsibility principle
//Controller heeft maar 1 taak en dat is de data van de restpoint binnen te krijgen en door te geven
//dus een controller ontvangt data en stuurt het door. Hiervoor heb je geen extra functionaliteiten nodig,
// alleen gevens die het ontvangen en doorsturen mogelijk maakt
//geldt voor de klasse als de methode

@RestController //spring weet dan dat we met een restcontroller te maken hebben
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private ActivityService activityService

    @GetMapping(value = "/api/trainer/{trainerId}") //downloaden
    public Trainer getTrainer(@PathVariable Long trainerId) {
        return trainerService.getTrainerById(trainerId);

    }

    @GetMapping(value = "/api/activity")
    public List<Activity> getActivities() {
        return activityService.getActivities();
    }


    @DeleteMapping(value="/api/trainer/{trainerId}")
    public boolean deleteTrainer(@PathVariable long trainerId) {
        return trainerService.deleteTrainerById(trainerId);
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


    @PostMapping(value = "/api/trainer") //localhost:8080/api/trainer // plaatsen
    public Trainer saveTrainer(@RequestBody Trainer newTrainer){
        return trainerService.save(newTrainer);
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
