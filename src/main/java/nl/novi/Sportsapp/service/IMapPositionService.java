package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.dto.request.PlaceMapsRequest;
import nl.novi.Sportsapp.model.MapPosition;
import org.springframework.http.ResponseEntity;

public interface IMapPositionService {
   ResponseEntity<MapPosition> addTrainingLocation(long trainerId, PlaceMapsRequest placeMapsRequest);

}
