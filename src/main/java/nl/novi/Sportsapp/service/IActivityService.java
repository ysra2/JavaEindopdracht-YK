package nl.novi.Sportsapp.service;

import com.google.maps.errors.ApiException;
import nl.novi.Sportsapp.dto.request.AddTrainingRequest;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.Activity;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface IActivityService {
    List<Activity> getActivity();
    ResponseEntity<Activity> addTraining(long trainerId, AddTrainingRequest addTrainingRequest) throws InterruptedException, ApiException, IOException;
    Activity updateUserById( long trainerId, Activity updateTrainerActivity);
    ResponseEntity<MessageResponse> deleteActivity(long activityId);
}
