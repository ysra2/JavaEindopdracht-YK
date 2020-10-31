package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.dto.request.AddTrainingRequest;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import org.springframework.http.ResponseEntity;

public interface IActivityService {
    ResponseEntity<MessageResponse> addTraining(Long trainerId, AddTrainingRequest addTrainingRequest);
//    Activity updateUserById(long userId, Activity updateTrainerActivity);

}
