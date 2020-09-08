package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.repository.ActivityRepository;
import nl.novi.Sportsapp.repository.SporterRepository;
import nl.novi.Sportsapp.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private SporterRepository sporterRepository;

    @GetMapping(value = "/api/activity")
    public List<Activity> getActivity() {
        List<Activity> activityList = activityRepository.findAll();
        return activityList;
    }
}
