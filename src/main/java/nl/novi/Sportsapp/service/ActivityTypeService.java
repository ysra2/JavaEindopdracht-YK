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

    public ActivityType saveActivityTypeTrainer(ActivityType saveActivityType){
        return activityTypeRepository.save(saveActivityType);
    }





}
