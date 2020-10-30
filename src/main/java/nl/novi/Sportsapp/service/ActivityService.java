package nl.novi.Sportsapp.service;


import nl.novi.Sportsapp.dto.request.AddTrainingRequest;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.repository.ActivityRepository;
import nl.novi.Sportsapp.repository.AppUserSportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActivityService implements IActivityService {

//    private static final String ROLE_NOT_FOUND_ERROR = "Error: Role is not found.";
    @Autowired
    private ActivityRepository activityRepository;
    private AppUserSportRepository appUserSportRepository;

//    RoleRepository roleRepository;
//
//    @Autowired
//    public void setRoleRepository(RoleRepository roleRepository) {
//        this.roleRepository = roleRepository;
//    }

    public List<Activity> getActivities() {
        List<Activity> activityList = activityRepository.findAll();
        return activityList;
    }

    @PreAuthorize("hasRole('TRAINER')")
    @Override
    public ResponseEntity<MessageResponse> addTraining(AddTrainingRequest addTrainingRequest) {
     //   AppUserSport appUserSport = appUserSportRepository(addTrainingRequest.getTrainer_user_id());
        // ADD TRAINING
        Activity activity = new Activity(
                addTrainingRequest.getLocation(),
                addTrainingRequest.getTime(),
                addTrainingRequest.getDate()
                );


//        AppUserSport trainer = addTrainingRequest.getTrainer();
        activityRepository.save(activity);
//
//        activity.setTrainer(activity.getTrainer());
//        activity.setTrainer(appUserSport);
//
//        AppUserSport strRoles = addTrainingRequest.getTrainer();
//        Set<Role> roles = new HashSet<>();
//
//        if (strRoles == null) {
//            Role userRole = roleRepository.findByName(ERole.ROLE_TRAINER)
//                    .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
//            roles.add(userRole);
//        }
//
//        activityRepository.save(activity);

        return ResponseEntity.ok(new MessageResponse("Training is successfully added!"));
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
