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

import javax.validation.Valid;
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
                () -> new UserSportNotFoundException("User"+ " " + userId + " " + " not found"));
    }


    //Put
    @PreAuthorize("hasRole('ROLE_TRAINER')")
    @Override
    public UserSports updateUserById (@Valid long trainerId, UserSports updateTrainer){
        return userSportsRepository.findById(trainerId).map(
                trainer -> {
                    trainer.setFirstname(updateTrainer.getFirstname());
                    trainer.setLastname(updateTrainer.getLastname());
                    trainer.setEmail(updateTrainer.getEmail());
                    trainer.setPassword(updateTrainer.getPassword());
                    return userSportsRepository.save(trainer);
                })
                // Kan de user niet vinden in database
                .orElseThrow( () -> new UserSportNotFoundException("Activity not found"));

    }

    //Delete users
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public ResponseEntity<MessageResponse> deleteTrainer(long id){
        Optional<UserSports> trainer = userSportsRepository.findById(id);
        if (trainer.isPresent()) {
            userSportsRepository.deleteById(id);
            return ResponseEntity
                    .ok()
                    .body(new MessageResponse("Succesfully deleted!"));
        }
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Unsuccesfully deleted!"));


    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public ResponseEntity<MessageResponse> deleteSporter(long id){
        Optional<UserSports> sporter = userSportsRepository.findById(id);
        if (sporter.isPresent()) {
            userSportsRepository.deleteById(id);
            return ResponseEntity
                    .ok()
                    .body(new MessageResponse("Succesfully deleted!"));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Unsuccesfully deleted!"));


    }
}