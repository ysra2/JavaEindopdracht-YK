
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


    @GetMapping("/trainer") //gegevens ophalen
    public List<UserSports> getTrainers() {
        return userSportsService.getTrainers();
    }

    @GetMapping("/sporter") //gegevens ophalen
    public List<UserSports> getSporters() {
        return userSportsService.getTrainers();
    }

    @GetMapping("/trainer/{userId}") // gegevens ophalen per Id trainer
    public UserSports getTrainer(@PathVariable long userId){
        return userSportsService.getTrainer(userId);
    }

    @GetMapping("/sporter/{userId}") // gegevens ophalen per Id sporter
    public UserSports getSporter(@PathVariable long userId){
        return userSportsService.getTrainer(userId);
    }

    @DeleteMapping("/admin/trainer/{id}") //gegevens verwijderen
    public boolean deleteTrainer(@PathVariable long id){
        return userSportsService.deleteTrainer(id);
    }

    @DeleteMapping("/admin/sporter/{id}") //gegevens verwijderen
    public ResponseEntity<MessageResponse> deleteSporter (@PathVariable long id){
        return userSportsService.deleteSporter(id);
    }

}