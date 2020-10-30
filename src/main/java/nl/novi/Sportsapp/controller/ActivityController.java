package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.dto.request.AddTrainingRequest;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping //downloaden
//    public List<Activity> getActivities() {
//        return activityService.getActivities();
//    }

    @PostMapping // activiteit toevoegen
    public ResponseEntity<MessageResponse> addTraining(@RequestBody AddTrainingRequest addTrainingRequest) {
        return activityService.addTraining(addTrainingRequest);
    }

//    @PutMapping("/trainer/{userId}")
//    // gegevens updaten, dit gaan trainers gebruiken om trainingen te updaten (in tijd/datum)
//    public Activity updateUserById(@PathVariable long userId, @RequestBody Activity updateTrainerActivity) {
//        return activityService.updateUserById(userId, updateTrainerActivity);
//    }
}
