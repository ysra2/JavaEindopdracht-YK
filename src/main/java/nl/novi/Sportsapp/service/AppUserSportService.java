package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.exception.UserSportNotFoundException;
import nl.novi.Sportsapp.model.AppUserSport;
import nl.novi.Sportsapp.repository.AppUserSportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


@Service
@Validated
public class AppUserSportService implements IAppUserSportService {


    @Autowired
    AppUserSportRepository appUserSportRepository;

    @PreAuthorize("hasRole('TRAINER')")
    @Override
    public List<AppUserSport> getTrainers() {
        List<AppUserSport> trainerList = appUserSportRepository.findAll();
        return trainerList;
    }

    @PreAuthorize("hasRole('TRAINER')")
    @Override
    public AppUserSport getTrainer(long id){
        return appUserSportRepository.findById(id).orElseThrow(
                () -> new UserSportNotFoundException(id));
    }

    @PreAuthorize("hasRole('TRAINER')")
    @Override
    public AppUserSport saveTrainer(AppUserSport newTrainer) {
        return appUserSportRepository.save(newTrainer);
    }

    @PreAuthorize("hasRole('TRAINER')")
    @Override
    public AppUserSport updateUserById(long id, AppUserSport updatedUserSport) {
        return appUserSportRepository.findById(id).map(
                user -> {
                    user.setEmail(updatedUserSport.getEmail());
                    user.setPassword(updatedUserSport.getPassword());
                    return appUserSportRepository.save(user);
                })
                // Kan de user niet vinden in database
                .orElseGet(() -> {
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

    @PreAuthorize("hasRole('TRAINER')")
    @Override
    public boolean deleteTrainer(long id){
    Optional<AppUserSport> trainer =appUserSportRepository.findById(id);
    if (trainer.isPresent()){
        appUserSportRepository.deleteById(id);
        return true;
    } else{
        return false;
    }
    }



}
