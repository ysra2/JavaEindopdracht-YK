package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.dto.request.AddTrainingRequest;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Single responsibility principle
//Controller heeft maar 1 taak en dat is de data van de restpoint binnen te krijgen en door te geven
//dus een controller ontvangt data en stuurt het door. Hiervoor heb je geen extra functionaliteiten nodig,
// alleen gevens die het ontvangen en doorsturen mogelijk maakt
//geldt voor de klasse als de methode

@CrossOrigin(origins =  "*", allowedHeaders = "*", maxAge = 3600, allowCredentials = "false" )
@RestController //spring weet dan dat we met een restcontroller te maken hebben
@RequestMapping(value = "/api/activity")
public class ActivityController {


    @Autowired //deze wordt gekoppeld met de service klasse
            ActivityService activityService;


//    @GetMapping
//    public List<Activity> getActivity() {
//        return activityService.getActivity();
//    }

    @GetMapping(value = "/{activityName}") //downloaden
    public List<Activity> getActivityByActivityName(@PathVariable String activityName) {
        return activityService.getActivitiesByActivityName(activityName);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/{trainerId}") // activiteit toevoegen
    public ResponseEntity<MessageResponse> addTraining(@RequestBody AddTrainingRequest addTrainingRequest,
                                                       @PathVariable long trainerId) {
        return activityService.addTraining(trainerId, addTrainingRequest);
    }

    @PutMapping(value = "/{activityId}")
    // gegevens updaten, dit gaan trainers gebruiken om trainingen te updaten (in tijd/datum)
    public Activity updateUserById(@RequestBody Activity updateTrainerActivity,
                                   @PathVariable long activityId) {
        return activityService.updateUserById(activityId, updateTrainerActivity);
    }

    @DeleteMapping(value = "/{activityId}")
    public ResponseEntity<MessageResponse> deleteActivity(@PathVariable long activityId){
        return activityService.deleteActivity(activityId);
    }
}