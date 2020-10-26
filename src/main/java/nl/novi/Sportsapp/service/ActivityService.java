package nl.novi.Sportsapp.service;


import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getActivities() {
        List<Activity> activityList = activityRepository.findAll();
        return activityList;
    }


//    public List<Activity> findActivityByPostalcode(String postalcode){
//        List<Activity> activity = new ArrayList<>();
//
//        List<Activity> foundActivity = activityRepository.findByPostalCode(postalcode);
//
//        return activity;
//
//    }

    public Activity updateTrainingById(long trainerId, Activity updateActivity) {
        return activityRepository.findById(trainerId).map(
                user -> {
                    user.setSportsActivity(updateActivity.getSportsActivity());
                    user.setLocation(updateActivity.getLocation());
                    user.setNameTrainer(updateActivity.getNameTrainer());
                    user.setDate(updateActivity.getDate());
                    user.setTime(updateActivity.getTime());
                    return activityRepository.save(user);
                })
                // Kan de user niet vinden in database
                .orElseGet(() -> {
                    updateActivity.setActivityId(trainerId);
                    return activityRepository.save(updateActivity);
                });
    }
}
