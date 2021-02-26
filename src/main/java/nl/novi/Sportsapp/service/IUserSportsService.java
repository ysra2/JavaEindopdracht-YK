package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.UserSports;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserSportsService {

   List<UserSports> getTrainers();
   List<UserSports> getSporters();
   UserSports getTrainer(long id);
   UserSports getSporter(long id);
   boolean deleteTrainer(long id);
   ResponseEntity<MessageResponse> deleteSporter(long id);


}
