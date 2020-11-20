package nl.novi.Sportsapp.service;


import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.novi.Sportsapp.dto.request.AddTrainingRequest;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.exception.UserSportNotFoundException;
import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.model.UserSports;
import nl.novi.Sportsapp.repository.ActivityRepository;
import nl.novi.Sportsapp.repository.UserSportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Service
public class ActivityService implements IActivityService {

    //    private static final String ROLE_NOT_FOUND_ERROR = "Error: Role is not found.";
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private UserSportsRepository userSportsRepository;

    //Get
    public List<Activity> getActivitiesByActivityName(String activityName) {
        List<Activity> activities = activityRepository.getActivitiesByActivityName(activityName);
        if(activities.isEmpty())
            return (List<Activity>) ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Activity not found."));

        return activities;
    }






    //Post
    @PreAuthorize("hasRole('TRAINER')")
    @Override
    @JsonIgnore
    public ResponseEntity<MessageResponse> addTraining(long trainerId, AddTrainingRequest addTrainingRequest) {
        Activity activity = new Activity(
                addTrainingRequest.getActivityName(),
                addTrainingRequest.getLocation(),
                addTrainingRequest.getTime(),
                addTrainingRequest.getDate()
        );

        Optional<UserSports> appUserSport = userSportsRepository.findById(trainerId);

        if (appUserSport.isPresent()) {
            activity.setTrainer(appUserSport.get());
            activityRepository.save(activity);

            Optional<UserSports> trainer = userSportsRepository.findById(trainerId);
            if (trainer.isPresent()) {
                UserSports trainerFromDb = trainer.get();
                List<Activity> activities = trainerFromDb.getActivities();

                activities.add(activity);
                trainerFromDb.setActivities(activities);

                activity.setTrainer(trainer.get());
                activityRepository.save(activity);
            }
            return ResponseEntity
                    .ok()
                    .body(new MessageResponse("Activity added."));
        }
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Trainer not found."));

    }



        //Put
        @PreAuthorize("hasRole('TRAINER')")
        @Override
        public Activity updateUserById ( @Valid long activityId, Activity updateTrainerActivity){
            return activityRepository.findById(activityId).map(
                    trainer -> {
                        trainer.setLocation(updateTrainerActivity.getLocation());
                        trainer.setTime(updateTrainerActivity.getTime());
                        trainer.setDate(updateTrainerActivity.getDate());
                        return activityRepository.save(trainer);
                    })
                    // Kan de user niet vinden in database
                    .orElseThrow( () -> new UserSportNotFoundException("Activity not found"));

        }


        //Delete
        @PreAuthorize("hasRole('TRAINER')")
        public ResponseEntity<MessageResponse> deleteActivity ( long activityId) {
            userSportsRepository.deleteById(activityId);
            return ResponseEntity
                    .ok()
                    .body(new MessageResponse("Succesfully deleted!"));
        }
}


