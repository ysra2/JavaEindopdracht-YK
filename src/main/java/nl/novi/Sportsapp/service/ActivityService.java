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

       //Get all activities
    public List<Activity> getActivity() {
        List<Activity> activityList = activityRepository.findAll();
        return activityList;
    }


    //Get{id}
    public List<Activity> getActivitiesByActivityName(String activityName) {
        List<Activity> activities = activityRepository.getActivitiesByActivityName(activityName);
        if (activities.isEmpty()) {
            ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Activity not found."));
        }
            return activities;
    }

    //Post
    @PreAuthorize("hasRole('ROLE_TRAINER')")
    @Override
    @JsonIgnore
    public ResponseEntity<Activity> addTraining(long trainerId,
                                                AddTrainingRequest addTrainingRequest) {
        Activity activity = new Activity(
                addTrainingRequest.getActivityName(),
                addTrainingRequest.getNameTrainer(),
                addTrainingRequest.getAddress(),
                addTrainingRequest.getZipcode(),
                addTrainingRequest.getCity(),
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
                    .ok(new Activity(
                            activity.getActivityId(),
                            activity.getActivityName(),
                            activity.getNameTrainer(),
                            activity.getAddress(),
                            activity.getZipcode(),
                            activity.getCity(),
                            activity.getTime(),
                            activity.getDate()

                    ));
        } else {
            ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Activity not found."));
        }

        return null;
    }

        //Put
     @PreAuthorize("hasRole('ROLE_TRAINER')")
     @Override
     public Activity updateUserById ( @Valid long activityId, Activity updateTrainerActivity){
        return activityRepository.findById(activityId).map(
                trainer -> {
                    trainer.setActivityName(updateTrainerActivity.getActivityName());
                    trainer.setAddress(updateTrainerActivity.getAddress());
                    trainer.setZipcode(updateTrainerActivity.getZipcode());
                    trainer.setCity(updateTrainerActivity.getCity());
                    trainer.setTime(updateTrainerActivity.getTime());
                    trainer.setDate(updateTrainerActivity.getDate());
                    return activityRepository.saveAndFlush(trainer);
                })// Kan de activity niet vinden in database
          .orElseThrow( () -> new UserSportNotFoundException("Activity not found"));
    }

        //Delete
    @PreAuthorize("hasRole('ROLE_TRAINER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<MessageResponse> deleteActivity(long activityId) {
        Optional<Activity> activity = activityRepository.findById(activityId);
        if (activity.isPresent()) {
            return ResponseEntity
                    .ok()
                    .body(new MessageResponse("Successfully deleted!"));
        } else {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Trainer not found."));

            }
        }


    @PreAuthorize("hasRole('ROLE_SPORTER')")
    public ResponseEntity<MessageResponse> acceptActivity( @Valid long activityId) {
        Optional<Activity> activity = activityRepository.findById(activityId);
        if (activity.isPresent()) {
            return ResponseEntity
                    .ok()
                    .body(new MessageResponse("Successfully accepted!"));
        } else {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error"));

        }
    }

    @PreAuthorize("hasRole('ROLE_SPORTER')")
    public ResponseEntity<MessageResponse> declineActivity(long activityId) {
        Optional<Activity> activity = activityRepository.findById(activityId);
        if (activity.isPresent()) {
            return ResponseEntity
                    .ok()
                    .body(new MessageResponse("Activiteit Geannuleerd!"));
        } else {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Geen activiteit gevonden."));

        }
    }

}


