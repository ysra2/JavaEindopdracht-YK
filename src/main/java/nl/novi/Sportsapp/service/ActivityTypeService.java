package nl.novi.Sportsapp.service;


import nl.novi.Sportsapp.dto.request.AddActivityTypeToTrainer;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.model.ActivityType;
import nl.novi.Sportsapp.model.AppUserSport;
import nl.novi.Sportsapp.repository.ActivityRepository;
import nl.novi.Sportsapp.repository.ActivityTypeRepository;
import nl.novi.Sportsapp.repository.AppUserSportRepository;
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
    AppUserSportRepository appUserSportRepository;

    @Autowired
    ActivityRepository activityRepository;

    public  List<ActivityType> getActivityType() {
        List<ActivityType> activityTypeList = activityTypeRepository.findAll();
        return activityTypeList;
    }

    public ActivityType saveActivityTypeTrainer(ActivityType saveActivityType){
        return activityTypeRepository.save(saveActivityType);
    }

    @Override
    public ActivityType updateTrainingById(long trainerId, ActivityType updateTraining, AddActivityTypeToTrainer addActivityTypeToTrainer) {
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
    public ResponseEntity<MessageResponse> addActivityToTrainer(long id, AddActivityTypeToTrainer addActivityTypeToTrainer){
        Activity activity = new Activity(
                addActivityTypeToTrainer.getActivityName()
        );

        Optional<AppUserSport> trainer = appUserSportRepository.findById(id);

        if (trainer.isPresent()){
            AppUserSport trainerFromDb = trainer.get();
            List<Activity> activities = trainerFromDb.getActivities();

            addActivityTypeToTrainer.setTrainer(trainerFromDb);

            activities.add(activity);
            trainerFromDb.setActivities(activities);

            activity.setTrainer(trainer.get());
            activityRepository.save(activity);


            return ResponseEntity
                    .ok()
                    .body(new MessageResponse("Activity added."));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("No activity added."));
    }
}
