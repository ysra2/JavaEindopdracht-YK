package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.dto.request.PlaceMapsRequest;
import nl.novi.Sportsapp.model.Maps;
import org.springframework.web.bind.annotation.RequestBody;

public interface IMapsService {
   Maps addTrainingLocation(@RequestBody long trainerId, Maps maps);
   Maps save(long trainerId, PlaceMapsRequest newMaps);
}
