package nl.novi.Sportsapp.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.novi.Sportsapp.dto.request.PlaceMapsRequest;
import nl.novi.Sportsapp.dto.response.MessageResponse;
import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.model.Maps;
import nl.novi.Sportsapp.model.UserSports;
import nl.novi.Sportsapp.repository.MapsRepository;
import nl.novi.Sportsapp.repository.UserSportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MapsService implements IMapsService {

    @Autowired
    private MapsRepository mapsRepository;

    @Autowired
    private UserSportsRepository userSportsRepository;

//    public List<Maps> getLocation() {
//        return mapsRepository.getLocation();
//    }

    public Maps save(Maps newLocationMap) {
        return mapsRepository.save(newLocationMap);
    }


    @PreAuthorize("hasRole('ROLE_TRAINER')")
    @JsonIgnore
    public ResponseEntity<MessageResponse> addTrainingLocation(long trainerId, PlaceMapsRequest placeMapsRequest) {
        Maps activityMaps = new Maps(
                placeMapsRequest.getLocation(),
                placeMapsRequest.getPlace(),
                placeMapsRequest.getLatitude(),
                placeMapsRequest.getLongitude()
        );

        Optional<UserSports> appUserSport = userSportsRepository.findById(trainerId);

        if (appUserSport.isPresent()) {
            activityMaps.setMapLocation(appUserSport.get());
            mapsRepository.save(activityMaps);

            Optional<UserSports> trainer = userSportsRepository.findById(trainerId);
            if (trainer.isPresent()) {
                UserSports trainerFromDb = trainer.get();
                List<Activity> activities = trainerFromDb.getActivities();

//                activities.add(activityMaps);
                trainerFromDb.setActivities(activities);

                activityMaps.setMapLocation(appUserSport.get());
                mapsRepository.save(activityMaps);
            }
            return ResponseEntity
                    .ok()
                    .body(new MessageResponse("add"));
        } else {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("error"));
        }

    }


    @Override
    public Maps addTrainingLocation(long trainerId, Maps maps) {
        return null;
    }

    @Override
    public Maps save(long trainerId, PlaceMapsRequest newMaps) {
        return null;
    }
}
