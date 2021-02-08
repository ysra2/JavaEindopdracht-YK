package nl.novi.Sportsapp.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.novi.Sportsapp.dto.request.PlaceMapsRequest;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.model.MapPosition;
import nl.novi.Sportsapp.model.UserSports;
import nl.novi.Sportsapp.repository.ActivityRepository;
import nl.novi.Sportsapp.repository.MapPositionRepository;
import nl.novi.Sportsapp.repository.UserSportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MapPositionService implements IMapPositionService {

    @Autowired
    private MapPositionRepository mapPositionRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private UserSportsRepository userSportsRepository;

//    public List<Maps> getLocation() {
//        return mapsRepository.getLocation();
//    }

    public MapPosition save(MapPosition newLocationMap) {
        return mapPositionRepository.save(newLocationMap);
    }


    @PreAuthorize("hasRole('ROLE_TRAINER')")
    @JsonIgnore
    public ResponseEntity<MapPosition> addTrainingLocation(long activityId, PlaceMapsRequest placeMapsRequest) {
        MapPosition mapPosition = new MapPosition(
                placeMapsRequest.getLatitude(),
                placeMapsRequest.getLongitude()
        );

        Optional<Activity> activity = activityRepository.findById(activityId);

        if (activity.isPresent()) {
            mapPosition.setMapLocation(activity.get());
            mapPositionRepository.save(mapPosition);

            Optional<UserSports> trainer = userSportsRepository.findById(activityId);
            if (trainer.isPresent()) {
                UserSports trainerFromDb = trainer.get();
                List<Activity> activities = trainerFromDb.getActivities();

//                activities.add(mapPosition);
                trainerFromDb.setActivities(activities);

                mapPosition.setMapLocation(activity.get());
                mapPositionRepository.save(mapPosition);

            }

            return ResponseEntity
                    .ok(new MapPosition(
                            mapPosition.getMapId(),
                            mapPosition.getLatitude(),
                            mapPosition.getLongitude()
                    ));
        } else {
            ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Location not found."));
        }
        return null;
    }


}

