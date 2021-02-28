package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.UserSports;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IUserSportsService {


   UserSports getAccountById(long userId);
   List<UserSports> getAccounts();
   ResponseEntity<MessageResponse> deleteAccounts(long id);

}
