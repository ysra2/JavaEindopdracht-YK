package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Single responsibility principle
//Controller heeft maar 1 taak en dat is de data van de restpoint binnen te krijgen en door te geven
//dus een controller ontvangt data en stuurt het door. Hiervoor heb je geen extra functionaliteiten nodig,
// alleen gevens die het ontvangen en doorsturen mogelijk maakt
//geldt voor de klasse als de methode

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController //spring weet dan dat we met een restcontroller te maken hebben
@RequestMapping("/api/activity")
public class ActivityController {

    @Autowired //deze wordt gekoppeld met de service klasse
    ActivityService activityService;

    @GetMapping //downloaden
    public List<Activity> getActivities() {
        return activityService.getActivities();
    }

//    @GetMapping
//    public List<Activity> findActivityByPostalcode(String postalcode){
//        return activityService.getActivities();
//    }

    @PutMapping("/trainer/{trainerId}")//updaten
    public Activity updateTrainingById(@PathVariable long trainerId, @RequestBody Activity updateActivity) {
        return activityService.updateTrainingById(trainerId, updateActivity);
    }
}
