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
import java.util.Set;


@Service
public class ActivityService implements IActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private UserSportsRepository userSportsRepository;

    //Get all activities
    @PreAuthorize("hasRole('ROLE_TRAINER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SPORTER')")
    public List<Activity> getActivity() {
        List<Activity> activityList = activityRepository.findAll();
        return activityList;
    }


    //Post
    @Override
    @PreAuthorize("hasRole('ROLE_TRAINER')")
    @JsonIgnore
    public ResponseEntity<Activity> addTraining(long trainerId, AddTrainingRequest addTrainingRequest) {
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
                Set<Activity> activities = trainerFromDb.getActivities();

                activities.add(activity);
                trainerFromDb.setActivities(activities);

                activity.setTrainer(trainer.get());
                activityRepository.save(activity);
            }

            return ResponseEntity
                    .ok()
                    .body(new Activity(
                            activity.getActivityId(),
                            activity.getActivityName(),
                            activity.getNameTrainer(),
                            activity.getAddress(),
                            activity.getZipcode(),
                            activity.getCity(),
                            activity.getTime(),
                            activity.getDate()
                    ));
        }
        return null;
    }

    //Put
    @PreAuthorize("hasRole('ROLE_TRAINER')")
    @Override
    public Activity updateUserById(@Valid long activityId, Activity updateTrainerActivity) {
        return activityRepository.findById(activityId).map(
                trainer -> {
                    trainer.setActivityName(updateTrainerActivity.getActivityName());
                    trainer.setAddress(updateTrainerActivity.getAddress());
                    trainer.setZipcode(updateTrainerActivity.getZipcode());
                    trainer.setCity(updateTrainerActivity.getCity());
                    trainer.setTime(updateTrainerActivity.getTime());
                    trainer.setDate(updateTrainerActivity.getDate());
                    return activityRepository.save(trainer);
                })// Kan de activity niet vinden in database
                .orElseThrow(() -> new UserSportNotFoundException("Activity not found"));
    }

    //Delete
    @PreAuthorize("hasRole('ROLE_TRAINER')")
    public ResponseEntity<MessageResponse> deleteActivity(long activityId) {
        if (activityRepository.findById(activityId).isPresent()) {
            activityRepository.deleteById(activityId);
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error"));


        } else return ResponseEntity
                .ok()
                .body(new MessageResponse("Successfully accepted!"));

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
            activityRepository.deleteById(activityId);
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

