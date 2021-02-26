package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.exception.UserSportNotFoundException;
import nl.novi.Sportsapp.model.UserSports;
import nl.novi.Sportsapp.repository.ActivityRepository;
import nl.novi.Sportsapp.repository.UserSportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TRAINER')")
    public List<UserSports> getTrainers() {
        List<UserSports> trainerList = userSportsRepository.findAll();
        return trainerList;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SPORTER')")
    public List<UserSports> getSporters() {
        List<UserSports> sporterList = userSportsRepository.findAll();
        return sporterList;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TRAINER')")
    public UserSports getTrainer(long userId){
        return userSportsRepository.findById(userId).orElseThrow(
                () -> new UserSportNotFoundException("User"+ " " + userId + " " + " not found"));
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SPORTER')")
    public UserSports getSporter(long userId){
        return userSportsRepository.findById(userId).orElseThrow(
                () -> new UserSportNotFoundException("User"+ " " + userId + " " + " not found"));
    }

    //Delete users
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public boolean deleteTrainer(long id){
        Optional<UserSports> trainer = userSportsRepository.findById(id);
        if (trainer.isPresent()){
            userSportsRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<MessageResponse> deleteSporter(long id){
        Optional<UserSports> sporter = userSportsRepository.findById(id);
        if (sporter.isPresent()) {
            userSportsRepository.deleteById(id);
            return ResponseEntity
                    .ok()
                    .body(new MessageResponse("Successfully deleted!"));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Unsuccessfully deleted!"));


    }
}