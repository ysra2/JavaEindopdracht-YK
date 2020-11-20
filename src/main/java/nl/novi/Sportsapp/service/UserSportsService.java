package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.exception.UserSportNotFoundException;
import nl.novi.Sportsapp.model.UserSports;
import nl.novi.Sportsapp.repository.UserSportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;


@Service
@Validated
public class UserSportsService implements IUserSportsService {


    @Autowired
    private UserSportsRepository userSportsRepository;


    @PreAuthorize("hasRole('TRAINER')")
    @Override
    public List<UserSports> getTrainers() {
        List<UserSports> trainerList = userSportsRepository.findAll();
        if(trainerList.isEmpty())
            return (List<UserSports>) ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Activity not found."));

        return trainerList;
    }
//
//    @PreAuthorize("hasRole('SPORTER') or haseRole('TRAINER')")
//    @Override
//    public List<UserSports> getNameTrainer(String firstName) {
//        List<UserSports> trainerList = userSportsRepository.getNameTrainer(firstName);
//        if(trainerList.isEmpty())
//            return (List<UserSports>) ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Activity not found."));
//
//        return trainerList;
//    }


    @Override
    public UserSports getTrainer(long userId){
        return userSportsRepository.findById(userId).orElseThrow(
                () -> new UserSportNotFoundException("User"+ " " + userId + " " + " not found"));
    }


    //Put
    @PreAuthorize("hasRole('TRAINER')")
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

//    @PreAuthorize("hasRole('TRAINER')")
//    @Override
//    public ResponseEntity<MessageResponse> deleteTrainer(long id){
//        Optional<UserSports> trainer = userSportsRepository.findById(id);
//        if (trainer.isPresent()) {
//            userSportsRepository.deleteById(id);
//            return ResponseEntity
//                    .ok()
//                    .body(new MessageResponse("Succesfully deleted!"));
//        }
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Succesfully deleted!"));
//
//
//    }

}