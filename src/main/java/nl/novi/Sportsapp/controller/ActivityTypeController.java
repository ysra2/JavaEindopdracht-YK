package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.model.ActivityType;
import nl.novi.Sportsapp.service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("trainer/{trainerId}")//updaten
    public ActivityType updateTrainingById(@PathVariable long trainerId, @RequestBody ActivityType updateActivityType) {
        return activityTypeService.updateTrainingById(trainerId, updateActivityType);
    }
}
