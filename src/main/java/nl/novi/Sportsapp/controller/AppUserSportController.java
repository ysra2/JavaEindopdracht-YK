
package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.model.AppUserSport;
import nl.novi.Sportsapp.service.AppUserSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping (value = "/api/app_user_sport")
public class AppUserSportController {

    @Autowired
    AppUserSportService appUserSportService;


    @GetMapping("/trainer") //gegevens ophalen
    public List<AppUserSport> getTrainers() {
        return appUserSportService.getTrainers();
    }


    @GetMapping("/trainer/{userId}") // gegevens ophalen per Id trainer
    public AppUserSport getTrainer(@PathVariable long userId){
        return appUserSportService.getTrainer(userId);
    }

    @PostMapping("/trainer/save")//localhost:8080/api/app_user_sport/trainer // gegevens trainer plaatsen
    public AppUserSport saveTrainer(@RequestBody AppUserSport newTrainer){
        return appUserSportService.saveTrainer(newTrainer);
    }



    @DeleteMapping("/trainer/{id}") //gegevens verwijderen
    public boolean deleteTrainer (@PathVariable long id){
        return appUserSportService.deleteTrainer(id);
    }


}