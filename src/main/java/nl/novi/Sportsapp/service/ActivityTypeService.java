package nl.novi.Sportsapp.service;


import nl.novi.Sportsapp.dto.request.AddTrainerActivity;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.ActivityType;
import nl.novi.Sportsapp.model.UserSports;
import nl.novi.Sportsapp.repository.ActivityRepository;
import nl.novi.Sportsapp.repository.ActivityTypeRepository;
import nl.novi.Sportsapp.repository.UserSportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityTypeService implements IActivityTypeService {

    @Autowired
    ActivityTypeRepository activityTypeRepository;

    @Autowired
    UserSportsRepository userSportsRepository;

    @Autowired
    ActivityRepository activityRepository;

    public  List<ActivityType> getActivityType() {
        List<ActivityType> activityTypeList = activityTypeRepository.findAll();
        return activityTypeList;
    }

    @Override
    public ActivityType updateTrainingById(long trainerId, ActivityType updateTraining, AddTrainerActivity addTrainerActivity) {
        return activityTypeRepository.findById(trainerId).map(
                user -> {
                    user.setActivityName(updateTraining.getActivityName());
                    return activityTypeRepository.save(user);
                })
                // Kan de user niet vinden in database
                .orElseGet(() -> {
                    updateTraining.setActivityTypeId(trainerId);
                    return activityTypeRepository.save(updateTraining);
                });
    }


    @PreAuthorize("hasRole('TRAINER')")
    public ResponseEntity<MessageResponse> addActivityToTrainer(long trainerId, AddTrainerActivity addTrainerActivity){
        ActivityType activityType = new ActivityType(
                addTrainerActivity.getActivityName()
        );

        Optional<UserSports> appUserSport = userSportsRepository.findById(trainerId);

        if(appUserSport.isPresent()) {
            activityType.setActivityTypeId(appUserSport.get());
            activityTypeRepository.save(activityType);

        return ResponseEntity
                    .ok()
                    .body(new MessageResponse("Activity added."));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("No activity added."));
    }
}
