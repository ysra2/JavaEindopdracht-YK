package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.dto.request.AddActivityTypeToTrainer;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.AppUserSport;
import nl.novi.Sportsapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

//    @GetMapping("/all")
//    public String allAccess() {
//        return testService.generatePublicContent();
//    }
//
//    @GetMapping("/sporter")
//    public String sporterAccess() {
//        return testService.generateSporterContent();
//    }
//
//    @GetMapping("/trainer")
//    public String trainerAccess() {
//        return testService.generateTrainerContent();
//    }
//
//    @GetMapping("/admin")
//    public String adminAccess() {
//        return testService.generateAdminContent();
//    }
//
//    @PostMapping("/trainer/trainer") // activiteit toevoegen
//    public ResponseEntity<MessageResponse> addTraining(@RequestBody AddTrainingRequest addTrainingRequest) {
//        return testService.addTraining(addTrainingRequest);
//    }

    // activiteit kan niet bestaan als er geen personaltrainer is
    // activiteit toevoegen op basis van trainer
    @PutMapping("/{id}/activity")
    public ResponseEntity<MessageResponse> addActivityToTrainer(@PathVariable long id,
                                                                @RequestBody AddActivityTypeToTrainer addActivityTypeToTrainer,
                                                                AppUserSport newActivity){
        return testService.addActivityToTrainer(id, addActivityTypeToTrainer, newActivity);
    }
}