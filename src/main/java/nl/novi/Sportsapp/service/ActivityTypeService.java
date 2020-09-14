package nl.novi.Sportsapp.service;


import nl.novi.Sportsapp.model.ActivityType;
import nl.novi.Sportsapp.repository.ActivityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeService {

    @Autowired
    ActivityTypeRepository activityTypeRepository;


    public  List<ActivityType> getActivityType() {
        List<ActivityType> activityTypeList = activityTypeRepository.findAll();
        return activityTypeList;
    }

    public ActivityType updateTrainingById(long trainerId, ActivityType updateTraining) {
        return activityTypeRepository.findById(trainerId).map(
                user -> {
                    user.setActivityname(updateTraining.getActivityname());
                    user.setLocation(updateTraining.getLocation());
                    user.setDate(updateTraining.getDate());
                    user.setTime(updateTraining.getTime());
                    return activityTypeRepository.save(user);
                })
                // Kan de user niet vinden in database
                .orElseGet(() -> {
                    updateTraining.setActivityTypeId(trainerId);
                    return activityTypeRepository.save(updateTraining);
                });
    }



}
