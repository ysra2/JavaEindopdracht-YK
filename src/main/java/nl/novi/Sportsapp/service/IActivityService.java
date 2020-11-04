package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.dto.request.AddTrainingRequest;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.Activity;
import org.springframework.http.ResponseEntity;

public interface IActivityService {
    ResponseEntity<MessageResponse> addTraining(long trainerId, AddTrainingRequest addTrainingRequest);
    Activity updateUserById( long trainerId, Activity updateTrainerActivity);

}
