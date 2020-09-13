package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.model.AppUserSport;
import nl.novi.Sportsapp.repository.ActivityRepository;
import nl.novi.Sportsapp.repository.AppUserSportRepository;
import nl.novi.Sportsapp.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


@Service
@Validated
public class AppUserSportService {

    @Autowired
    AppUserSportRepository appUserSportRepository;
    RoleRepository roleRepository;
    ActivityRepository activityRepository;

    public List<AppUserSport> getTrainers() {
        List<AppUserSport> trainerList = appUserSportRepository.findAll();
        return trainerList;
    }

//    public AppUserSport saveTrainer(AppUserSport newTrainer) {
//        return appUserSportRepository.save(newTrainer);
//    }

    public AppUserSport updateUserById(long id, AppUserSport updatedUserSport) {
        return appUserSportRepository.findById(id).map(
                user -> {
                    user.setUsername(updatedUserSport.getUsername());
                    user.setEmail(updatedUserSport.getEmail());
                    return appUserSportRepository.save(user);
                })
                // Kan de user niet vinden in database
                .orElseGet(() -> {
                    updatedUserSport.setUserId(id);
                    return appUserSportRepository.save(updatedUserSport);
                });
    }

//    public AppUserSport addActivityToTrainer(long id,  Activity newActivity){
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

    public boolean deleteTrainer(long id){
    Optional<AppUserSport> trainer =appUserSportRepository.findById(id);
    if (trainer.isPresent()){
        appUserSportRepository.deleteById(id);
        return true;
    } else{
        return false;
    }
    }

    /**Ik kan dit pas toevoegen als ik security heb toegevoegd in Intellij/project**/
//public ResponseEntity<SigninSporterResponse> registerUser(@Valid SignupRequest signUpRequest) {
//    if (Boolean.TRUE.equals(appUserSportRepository.existsByUsername(signUpRequest.getUsername()))) {
//        return ResponseEntity
//                .badRequest()
//                .body(new SigninSporterResponse("Error: Username is already taken!"));
//    }
//
//    if (Boolean.TRUE.equals(appUserSportRepository.existsByEmail(signUpRequest.getEmail()))) {
//        return ResponseEntity
//                .badRequest()
//                .body(new SigninSporterResponse("Error: Email is already in use!"));
//    }
//
//    // Create new user's account
//    User user = new User(signUpRequest.getUsername(),
//            signUpRequest.getEmail(),
//            encoder.encode(signUpRequest.getPassword()));
//
//    Set<String> strRoles = signUpRequest.getRole();
//    Set<Role> roles = new HashSet<>();
//
//    if (strRoles == null) {
//        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//                .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
//        roles.add(userRole);
//    } else {
//        strRoles.forEach(role -> {
//            switch (role) {
//                case "admin":
//                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//                            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
//                    roles.add(adminRole);
//
//                    break;
//                case "mod":
//                    Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
//                            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
//                    roles.add(modRole);
//
//                    break;
//                default:
//                    Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//                            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
//                    roles.add(userRole);
//            }
//        });
//    }
//
//    user.setRoles(roles);
//    appUserSportRepository.save(user);
//
//    return ResponseEntity.ok(new SigninSporterResponse("User registered successfully!"));
//}
}
