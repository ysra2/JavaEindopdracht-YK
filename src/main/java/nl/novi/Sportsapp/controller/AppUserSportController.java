package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.model.AppUserSport;
import nl.novi.Sportsapp.repository.AppUserSportRepository;
import nl.novi.Sportsapp.service.AppUserSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/app_user_sport")
public class AppUserSportController {

    @Autowired
    AppUserSportService appUserSportService;

    @GetMapping("/trainer") //gegevens ophalen
    public List<AppUserSport> getTrainers() {
        return appUserSportService.getTrainers();
    }

    @GetMapping("/trainer/{id}")
    public AppUserSport getTrainer(@PathVariable long id){
        return appUserSportService.getTrainer(id);
    }

    @PostMapping("/trainer")//localhost:8080/api/app_user_sport/trainer // gegevens trainer plaatsen
    public AppUserSport saveTrainer(@RequestBody AppUserSport newTrainer){
        return appUserSportService.saveTrainer(newTrainer);
    }

    @PutMapping("/trainer/{id}")// gegevens updaten, dit gaan trainers gebruiken om trainingen te updaten (in tijd/datum)
    public AppUserSport updateUserById(@PathVariable long id, @RequestBody AppUserSport updatedUserSport) {
        return appUserSportService.updateUserById(id, updatedUserSport);
    }
    // activiteit kan niet bestaan als er geen personaltrainer is
    // activiteit toevoegen op basis van trainer
//    @PostMapping("/trainer/{id}/activity")
//    public AppUserSport addActivityToTrainer(@PathVariable long id, @RequestBody Activity newActivity){
//        return appUserSportService.addActivityToTrainer(id, newActivity);
//    }

    @DeleteMapping("/trainer/{id}") //gegevens verwijderen
    public boolean deleteTrainer (@PathVariable long id){
        return appUserSportService.deleteTrainer(id);
    }


}