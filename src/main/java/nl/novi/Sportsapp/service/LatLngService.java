//package nl.novi.Sportsapp.service;
//
//import nl.novi.Sportsapp.dto.request.PlaceMapsRequest;
//import nl.novi.Sportsapp.model.LatLng;
//import nl.novi.Sportsapp.repository.ActivityRepository;
//import nl.novi.Sportsapp.repository.LatLngRepository;
//import nl.novi.Sportsapp.repository.UserSportsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class LatLngService implements IMapPositionService {
//
//    @Autowired
//    private LatLngRepository latLngRepository;
//
//    @Autowired
//    private ActivityRepository activityRepository;
//
//    @Autowired
//    private UserSportsRepository userSportsRepository;
//
//    public List<LatLng> getLocation() {
//        List<LatLng> latLngList = latLngRepository.findAll();
//        return latLngList;
//    }
//
//    public LatLng save(LatLng newLocationMap) {
//        return latLngRepository.save(newLocationMap);
//    }
//
//
//    @Override
//    public ResponseEntity<LatLng> addTrainingLocation(long trainerId, PlaceMapsRequest placeMapsRequest) {
//        return null;
//    }
//}
//
//
////@PreAuthorize("hasRole('ROLE_TRAINER')")
////    @JsonIgnore
////    public ResponseEntity<LatLng> addTrainingLocation(long activityId, PlaceMapsRequest placeMapsRequest) {
////        LatLng latLng = new LatLng(
////                placeMapsRequest.getLatitude(),
////                placeMapsRequest.getLongitude()
////        );
////
////        Optional<Activity> activity = activityRepository.findById(activityId);
////
////        if (activity.isPresent()) {
////            latLng.setMapLocation(activity.get());
////            latLngRepository.save(latLng);
////
////            Optional<UserSports> trainer = userSportsRepository.findById(activityId);
////            if (trainer.isPresent()) {
////                UserSports trainerFromDb = trainer.get();
////                List<Activity> activities = trainerFromDb.getActivities();
////
//////                activities.add(mapPosition);
////                trainerFromDb.setActivities(activities);
////
////                latLng.setMapLocation(activity.get());
////                latLngRepository.save(latLng);
////
////            }
////
////            return ResponseEntity
////                    .ok(new LatLng(
////                            latLng.getMapId(),
////                            latLng.getLat(),
////                            latLng.getLng()
////                    ));
////        } else {
////            ResponseEntity
////                    .badRequest()
////                    .body(new MessageResponse("Location not found."));
////        }
////        return null;
////    }
