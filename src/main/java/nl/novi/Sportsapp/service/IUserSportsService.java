package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.UserSports;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

public interface IUserSportsService {

   List<UserSports> getTrainers();
   UserSports getTrainer(long id);
   UserSports updateUserById (@Valid long trainerId, UserSports updateTrainer);
   ResponseEntity<MessageResponse> deleteTrainer(long id);
//   AppUserSport saveTrainer(AppUserSport newTrainer, AddActivityTypeToTrainer addActivityTypeToTrainer);

}
