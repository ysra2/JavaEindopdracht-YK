package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.dto.request.LoginRequest;
import nl.novi.Sportsapp.dto.response.JwtResponse;
import nl.novi.Sportsapp.model.AppUserSport;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAppUserSportService {

   ResponseEntity<JwtResponse> authAppUserSport(LoginRequest loginRequest);
   List<AppUserSport> getTrainers();
   AppUserSport getTrainer(long id);
   AppUserSport saveTrainer(AppUserSport newTrainer);
   AppUserSport updateUserById(long id, AppUserSport updatedUserSport);
   boolean deleteTrainer(long id);

}
