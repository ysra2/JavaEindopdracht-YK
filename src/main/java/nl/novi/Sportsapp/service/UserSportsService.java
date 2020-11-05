package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.exception.UserSportNotFoundException;
import nl.novi.Sportsapp.model.UserSports;
import nl.novi.Sportsapp.repository.ActivityRepository;
import nl.novi.Sportsapp.repository.UserSportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


@Service
@Validated
public class UserSportsService implements IUserSportsService {


    @Autowired
    private UserSportsRepository userSportsRepository;


    @Autowired
    private ActivityRepository activityRepository;


    @Override
    public List<UserSports> getTrainers() {
        List<UserSports> trainerList = userSportsRepository.findAll();
        return trainerList;
    }

    @Override
    public UserSports getTrainer(long userId){
        return userSportsRepository.findById(userId).orElseThrow(
                () -> new UserSportNotFoundException(userId));
    }

//    @PreAuthorize("hasRole('TRAINER')")
//    @Override
//    public UserSports saveTrainer(UserSports newTrainer) {
//        return userSportsRepository.save(newTrainer);
//    }


    @PreAuthorize("hasRole('TRAINER') or hasRole('ADMIN')")
    @Override
    public boolean deleteTrainer(long id){
        Optional<UserSports> trainer = userSportsRepository.findById(id);
        if (trainer.isPresent()){
            userSportsRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }



}