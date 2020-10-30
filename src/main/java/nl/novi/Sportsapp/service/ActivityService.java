package nl.novi.Sportsapp.service;


import nl.novi.Sportsapp.dto.request.AddTrainingRequest;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.model.AppUserSport;
import nl.novi.Sportsapp.repository.ActivityRepository;
import nl.novi.Sportsapp.repository.AppUserSportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ActivityService implements IActivityService {

//    private static final String ROLE_NOT_FOUND_ERROR = "Error: Role is not found.";
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private AppUserSportRepository appUserSportRepository;

//    RoleRepository roleRepository;
//
//    @Autowired
//    public void setRoleRepository(RoleRepository roleRepository) {
//        this.roleRepository = roleRepository;
//    }

    public List<Activity> getActivities() {

        return activityRepository.findAll();
    }

    @PreAuthorize("hasRole('TRAINER')")
    @Override
    public ResponseEntity<MessageResponse> addTraining(Long trainerId, AddTrainingRequest addTrainingRequest) {
        Activity activity = new Activity(
                addTrainingRequest.getLocation(),
                addTrainingRequest.getTime(),
                addTrainingRequest.getDate()
                );

        Optional<AppUserSport> appUserSport = appUserSportRepository.findById(trainerId);

        if(appUserSport.isPresent()) {
            activity.setTrainer(appUserSport.get());
            activityRepository.save(activity);

            return ResponseEntity
                    .ok()
                    .body(new MessageResponse("Activity added."));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Trainer not found."));
    }

//    @PreAuthorize("hasRole('TRAINER')")
//    @Override
//    public Activity updateUserById(@Valid long userId, Activity updateTrainerActivity) {
//        return activityRepository.findById(userId).map(
//                trainer -> {
//                    trainer.setTrainingactivity(updateTrainerActivity.getTrainingactivity());
//                    trainer.setNameTrainer(updateTrainerActivity.getNameTrainer());
//                    trainer.setLocation(updateTrainerActivity.getLocation());
//                    trainer.setTime(updateTrainerActivity.getTime());
//                    trainer.setDate(updateTrainerActivity.getDate());
//                    return activityRepository.save(trainer);
//                })
//                // Kan de user niet vinden in database
//                .orElseGet(() -> {
//                    return activityRepository.save(updateTrainerActivity);
//                });
//    }

}
