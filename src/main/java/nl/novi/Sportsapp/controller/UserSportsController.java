
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


    @GetMapping("/trainer/{userId}") // gegevens ophalen per Id trainer
    public UserSports getTrainer(@PathVariable long userId){
        return userSportsService.getTrainer(userId);
    }

    @PutMapping("/{trainerId}")
    // gegevens updaten, dit gaan trainers gebruiken om trainingen te updaten (in tijd/datum)
    public UserSports updateUserById(@RequestBody UserSports updateTrainer,
                                   @PathVariable long trainerId) {
        return userSportsService.updateUserById(trainerId, updateTrainer);
    }

    @DeleteMapping("/trainer/{id}") //gegevens verwijderen
    public ResponseEntity<MessageResponse> deleteTrainer (@PathVariable long id){
        return userSportsService.deleteTrainer(id);
    }

    @DeleteMapping("/sporter/{id}") //gegevens verwijderen
    public ResponseEntity<MessageResponse> deleteSporter (@PathVariable long id){
        return userSportsService.deleteSporter(id);
    }

}