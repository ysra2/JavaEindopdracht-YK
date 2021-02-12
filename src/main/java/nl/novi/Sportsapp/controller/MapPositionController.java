package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.dto.request.PlaceMapsRequest;
import nl.novi.Sportsapp.model.MapPosition;
import nl.novi.Sportsapp.service.MapPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins =  "*", allowedHeaders = "*", maxAge = 3600, allowCredentials = "false" )
@RestController //spring weet dan dat we met een restcontroller te maken hebben
@RequestMapping(value = "/api/maps")
public class MapPositionController {

    @Autowired
    private MapPositionService mapPositionService;

    @GetMapping
    public List<MapPosition> getLocation() {
        return mapPositionService.getLocation();
    }

    @PostMapping(value="/place")
    public MapPosition newLocationOnMap(@RequestBody MapPosition newLocationMap ){
        return mapPositionService.save(newLocationMap);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "place/{activityId}") // activiteit toevoegen
    public ResponseEntity<MapPosition> addTrainingLocation(@RequestBody PlaceMapsRequest placeMapsRequest,
                                                               @PathVariable long activityId) {
        return mapPositionService.addTrainingLocation(activityId, placeMapsRequest);
    }


}
