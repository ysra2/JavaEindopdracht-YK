package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.dto.request.PlaceMapsRequest;
import nl.novi.Sportsapp.model.Maps;
import nl.novi.Sportsapp.service.MapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins =  "*", allowedHeaders = "*", maxAge = 3600, allowCredentials = "false" )
@RestController //spring weet dan dat we met een restcontroller te maken hebben
@RequestMapping(value = "/api/maps")
public class MapsController {

    @Autowired
    private MapsService mapsService;

//    @GetMapping
//    public List<Maps> getLocation() {
//        return mapsService.getLocation();
//    }

    @PostMapping(value="/place")
    public Maps newLocationOnMap(@RequestBody Maps newLocationMap ){
        return mapsService.save(newLocationMap);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/{trainerId}") // activiteit toevoegen
    public Maps addTrainingLocation(@RequestBody PlaceMapsRequest placeMapsRequest,
                                    @PathVariable long trainerId) {
        return mapsService.save(trainerId, placeMapsRequest);
    }








}
