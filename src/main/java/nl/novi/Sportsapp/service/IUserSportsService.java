package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.model.UserSports;

import java.util.List;

public interface IUserSportsService {

   List<UserSports> getTrainers();
   UserSports getTrainer(long id);
//   UserSports saveTrainer(UserSports newTrainer);
   boolean deleteTrainer(long id);
//   AppUserSport saveTrainer(AppUserSport newTrainer, AddActivityTypeToTrainer addActivityTypeToTrainer);

}
