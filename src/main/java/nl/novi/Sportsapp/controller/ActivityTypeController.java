package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.dto.request.AddActivityTypeToTrainer;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.ActivityType;
import nl.novi.Sportsapp.service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/activity_type")
public class ActivityTypeController {

    @Autowired
    ActivityTypeService activityTypeService;


    @GetMapping
    List<ActivityType> getActivityType(){
        return activityTypeService.getActivityType();
    }

    @PutMapping("/{trainerId}")//updaten
    public ActivityType updateTrainingById(@PathVariable long trainerId,
                                           @RequestBody ActivityType updateActivityType,
                                           @RequestBody AddActivityTypeToTrainer addActivityTypeToTrainer) {
        return activityTypeService.updateTrainingById(trainerId, updateActivityType, addActivityTypeToTrainer);
    }

    // activiteit kan niet bestaan als er geen personaltrainer is
    // activiteit toevoegen op basis van trainer
    @PutMapping("/trainer/{id}/activity")
    public ResponseEntity<MessageResponse> addActivityToTrainer(@PathVariable long id,
                                                                @RequestBody AddActivityTypeToTrainer addActivityTypeToTrainer){
        return activityTypeService.addActivityToTrainer(id, addActivityTypeToTrainer);
    }
}
