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

import java.util.List;
import java.util.Optional;


@Service
@Validated
public class UserSportsService implements IUserSportsService {


    @Autowired
    private UserSportsRepository userSportsRepository;


    @Override
    public UserSports getAccountById(long userId){
        return userSportsRepository.findById(userId).orElseThrow(
                () -> new UserSportNotFoundException("User"+ " " + userId + " " + " not found"));
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserSports> getAccounts() {
        List<UserSports> sporterList = userSportsRepository.findAll();
        return sporterList;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<MessageResponse> deleteAccounts(long id){
        Optional<UserSports> sporter = userSportsRepository.findById(id);
        if (sporter.isPresent()) {
            userSportsRepository.deleteById(id);
            return ResponseEntity
                    .ok()
                    .body(new MessageResponse("Account successfully deleted!"));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Account NOT deleted!"));


    }
}