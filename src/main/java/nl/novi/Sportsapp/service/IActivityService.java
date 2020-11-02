package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.dto.request.AddTrainingRequest;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.Activity;
import org.springframework.http.ResponseEntity;

public interface IActivityService {
    ResponseEntity<MessageResponse> addTraining(Long trainerId, AddTrainingRequest addTrainingRequest);
    Activity updateUserById( Long trainerId, Activity updateTrainerActivity);

}
