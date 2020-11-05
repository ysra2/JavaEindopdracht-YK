
package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.model.UserSports;
import nl.novi.Sportsapp.service.UserSportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
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

//    @PostMapping("/trainer/save")//localhost:8080/api/app_user_sport/trainer // gegevens trainer plaatsen
//    public UserSports saveTrainer(@RequestBody UserSports newTrainer){
//        return userSportsService.saveTrainer(newTrainer);
//    }

    @DeleteMapping("/trainer/{id}") //gegevens verwijderen
    public boolean deleteTrainer (@PathVariable long id){
        return userSportsService.deleteTrainer(id);
    }


}