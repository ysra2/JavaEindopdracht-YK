
package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.UserSports;
import nl.novi.Sportsapp.service.UserSportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*"}, maxAge = 3600)
@RestController
@RequestMapping (value = "/api/user_sports")
public class UserSportsController {

    @Autowired
    UserSportsService userSportsService;


    @GetMapping("/account/{userId}") // gegevens ophalen per Id accounts
    public UserSports getAccountById(@PathVariable long userId){
        return userSportsService.getAccountById(userId);
    }

    @GetMapping("/accounts") //gegevens ophalen/lijst van alle geregistreerde accounts
    public List<UserSports> getAccounts() {
        return userSportsService.getAccounts();
    }

    @DeleteMapping("/admin/accounts/{id}") //gegevens verwijderen
    public ResponseEntity<MessageResponse> deleteSporter (@PathVariable long id){
        return userSportsService.deleteAccounts(id);
    }

}