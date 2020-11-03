package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.dto.request.AddActivityTypeToTrainer;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.exception.UserSportNotFoundException;
import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.model.AppUserSport;
import nl.novi.Sportsapp.repository.ActivityRepository;
import nl.novi.Sportsapp.repository.AppUserSportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


@Service
@Validated
public class AppUserSportService implements IAppUserSportService {


    @Autowired
    private AppUserSportRepository appUserSportRepository;


    @Autowired
    private ActivityRepository activityRepository;


    @Override
    public List<AppUserSport> getTrainers() {
        List<AppUserSport> trainerList = appUserSportRepository.findAll();
        return trainerList;
    }

    @Override
    public AppUserSport getTrainer(long userId){
        return appUserSportRepository.findById(userId).orElseThrow(
                () -> new UserSportNotFoundException(userId));
    }

    @PreAuthorize("hasRole('TRAINER')")
    @Override
    public AppUserSport saveTrainer(AppUserSport newTrainer) {
        return appUserSportRepository.save(newTrainer);
    }


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