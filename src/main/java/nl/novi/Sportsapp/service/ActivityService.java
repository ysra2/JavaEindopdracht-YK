package nl.novi.Sportsapp.service;


import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.model.AppUserSport;
import nl.novi.Sportsapp.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getActivities() {
        List<Activity> activityList = activityRepository.findAll();
        return activityList;
    }



}
