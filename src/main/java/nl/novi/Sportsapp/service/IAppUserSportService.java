package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.model.AppUserSport;

import java.util.List;

public interface IAppUserSportService {

   List<AppUserSport> getTrainers();
   AppUserSport getTrainer(long id);
   AppUserSport saveTrainer(AppUserSport newTrainer);
   boolean deleteTrainer(long id);
//   AppUserSport saveTrainer(AppUserSport newTrainer, AddActivityTypeToTrainer addActivityTypeToTrainer);

}
