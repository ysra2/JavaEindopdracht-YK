package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.model.UserSports;

import javax.validation.Valid;
import java.util.List;

public interface IUserSportsService {

   List<UserSports> getTrainers();
//   List<UserSports> getNameTrainer(String firstName);

   UserSports getTrainer(long id);
   UserSports updateUserById (@Valid long trainerId, UserSports updateTrainer);
//   ResponseEntity<MessageResponse> deleteTrainer(long id);
//   AppUserSport saveTrainer(AppUserSport newTrainer, AddActivityTypeToTrainer addActivityTypeToTrainer);

}
