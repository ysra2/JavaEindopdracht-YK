package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.dto.request.AddActivityTypeToTrainer;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.model.AppUserSport;
import nl.novi.Sportsapp.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private ActivityRepository activityRepository;

//    public String generatePublicContent() {
//        return "Public Content.";
//    }
//
//    @PreAuthorize("hasRole('SPORTER') or hasRole('TRAINER') or hasRole('ADMIN')")
//    public String generateUserContent() {
//        return "User Content.";
//    }
//
//    @PreAuthorize("hasRole('SPORTER')")
//    public String generateSporterContent() {
//        return "Sporter Board.";
//    }
//
//    @PreAuthorize("hasRole('TRAINER')")
//    public String generateTrainerContent() {
//        return "Trainer Board.";
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    public String generateAdminContent() {
//        return "Admin Board.";
//    }
//
//    @PreAuthorize("hasRole('TRAINER')")
//    public ResponseEntity<MessageResponse> addTraining(AddTrainingRequest addTrainingRequest) {
//
//        // ADD TRAINING
//        Activity activity = new Activity(
//                addTrainingRequest.getLocation(),
//                addTrainingRequest.getTime(),
//                addTrainingRequest.getDate()
//        );
//
//        activityRepository.save(activity);
//
//        return ResponseEntity.ok(new MessageResponse("Training is successfully added!"));
//    }



//    public AppUserSport addActivityToTrainer(long id, Activity newActivity){
//        Optional<Activity> trainer = activityRepository.findById(id);
//
//        if (trainer.isPresent()){
//            AppUserSport trainerFromDb = trainer.get();
//            List<AppUserSport> currentActivities = trainerFromDb.getUserId();
//
//            newActivity.setActivityId(trainerFromDb);
//
//            currentActivities.add(newActivity);
//            trainerFromDb.setUserId((AppUserSport) currentActivities);
//
//        }
//        return null;
//    }


    public ResponseEntity<MessageResponse> addActivityToTrainer(long id, AddActivityTypeToTrainer addActivityTypeToTrainer, AppUserSport newActivity){
        Activity activity = new Activity(
                addActivityTypeToTrainer.getActivityName()
        );

        Optional<Activity> trainer = activityRepository.findById(id);

        if (trainer.isPresent()){
            Activity trainerFromDb = trainer.get();
            List<AppUserSport> activities = trainerFromDb.getSporters();

            newActivity.setActivitiesAsTrainer((List<Activity>) trainerFromDb);

            activities.add(newActivity);
            trainerFromDb.setSporters(activities);

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