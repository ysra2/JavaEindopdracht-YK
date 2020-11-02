//package nl.novi.Sportsapp.service;
//
//import nl.novi.Sportsapp.dto.request.AddTrainingRequest;
//import nl.novi.Sportsapp.dto.response.MessageResponse;
//import nl.novi.Sportsapp.model.Activity;
//import nl.novi.Sportsapp.repository.ActivityRepository;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TestService {
//
//    ActivityRepository activityRepository;
//
//    public String generatePublicContent() {
//        return "Public Content.";
//    }
//
//    @PreAuthorize("hasRole('SPORTER') or hasRole('TRAINER') or hasRole('ADMIN')")
//    public String generateUserContent() {
//        return "User Content.";
//    }
//
//    @PreAuthorize("hasRole('SPORTER')")
//    public String generateSporterContent() {
//        return "Sporter Board.";
//    }
//
//    @PreAuthorize("hasRole('TRAINER')")
//    public String generateTrainerContent() {
//        return "Trainer Board.";
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    public String generateAdminContent() {
//        return "Admin Board.";
//    }
//
//    @PreAuthorize("hasRole('TRAINER')")
//    public ResponseEntity<MessageResponse> addTraining(AddTrainingRequest addTrainingRequest) {
//
//        // ADD TRAINING
//        Activity activity = new Activity(
//                addTrainingRequest.getLocation(),
//                addTrainingRequest.getTime(),
//                addTrainingRequest.getDate()
//        );
//
//        activityRepository.save(activity);
//
//        return ResponseEntity.ok(new MessageResponse("Training is successfully added!"));
//    }
//
//}