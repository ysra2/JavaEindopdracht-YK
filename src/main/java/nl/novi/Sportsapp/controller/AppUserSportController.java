package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.model.AppUserSport;
import nl.novi.Sportsapp.service.AppUserSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping //(value = "/api/app_user_sport")
public class AppUserSportController {

    @Autowired
    AppUserSportService appUserSportService;


    @GetMapping("/api/app_user_sport/trainer") //gegevens ophalen
    public List<AppUserSport> getTrainers() {
        return appUserSportService.getTrainers();
    }


    @GetMapping("/api/app_user_sport/trainer/{userId}") // gegevens ophalen per Id trainer
    public AppUserSport getTrainer(@PathVariable long userId){
        return appUserSportService.getTrainer(userId);
    }

    @PostMapping("/api/app_user_sport/trainer/save")//localhost:8080/api/app_user_sport/trainer // gegevens trainer plaatsen
    public AppUserSport saveTrainer(@RequestBody AppUserSport newTrainer){
        return appUserSportService.saveTrainer(newTrainer);
    }

    @PutMapping("/api/app_user_sport/trainer/{id}")// gegevens updaten, dit gaan trainers gebruiken om trainingen te updaten (in tijd/datum)
    public AppUserSport updateUserById(@PathVariable long id, @RequestBody AppUserSport updatedUserSport) {
        return appUserSportService.updateUserById(id, updatedUserSport);
    }
    // activiteit kan niet bestaan als er geen personaltrainer is
    // activiteit toevoegen op basis van trainer
//    @PostMapping("/trainer/{id}/activity")
//    public AppUserSport addActivityToTrainer(@PathVariable long id, @RequestBody Activity newActivity){
//        return appUserSportService.addActivityToTrainer(id, newActivity);
//    }

    @DeleteMapping("/api/app_user_sport/trainer/{id}") //gegevens verwijderen
    public boolean deleteTrainer (@PathVariable long id){
        return appUserSportService.deleteTrainer(id);
    }


}