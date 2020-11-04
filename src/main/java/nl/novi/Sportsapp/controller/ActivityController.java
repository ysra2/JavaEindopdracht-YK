package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.dto.request.AddTrainingRequest;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.service.ActivityService;
import nl.novi.Sportsapp.service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Single responsibility principle
//Controller heeft maar 1 taak en dat is de data van de restpoint binnen te krijgen en door te geven
//dus een controller ontvangt data en stuurt het door. Hiervoor heb je geen extra functionaliteiten nodig,
// alleen gevens die het ontvangen en doorsturen mogelijk maakt
//geldt voor de klasse als de methode

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController //spring weet dan dat we met een restcontroller te maken hebben
@RequestMapping(value = "/api/activity")
public class ActivityController {


    @Autowired //deze wordt gekoppeld met de service klasse
            ActivityService activityService;


    @Autowired //deze wordt gekoppeld met de service klasse
            ActivityTypeService activityTypeService;

    @GetMapping //downloaden
    public List<Activity> getActivities() {
        return activityService.getActivities();
    }

    @PostMapping(value = "{trainerId}") // activiteit toevoegen
    public ResponseEntity<MessageResponse> addTraining(@RequestBody AddTrainingRequest addTrainingRequest,
                                                       @PathVariable long trainerId) {
        return activityService.addTraining(trainerId, addTrainingRequest);
    }

    @PutMapping("{activityId}")
    // gegevens updaten, dit gaan trainers gebruiken om trainingen te updaten (in tijd/datum)
    public Activity updateUserById(@RequestBody Activity updateTrainerActivity,
                                   @PathVariable long activityId) {
        return activityService.updateUserById(activityId, updateTrainerActivity);
    }

    @DeleteMapping(value = "{activityId}")
    public boolean deleteActivity(@PathVariable long activityId){
        return activityService.deleteActivity(activityId);
    }
}