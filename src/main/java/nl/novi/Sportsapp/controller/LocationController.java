package nl.novi.Sportsapp.controller;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import nl.novi.Sportsapp.model.Location;
import nl.novi.Sportsapp.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = { "*"}, maxAge = 3600)
@RestController
@RequestMapping("/api/map")
public class LocationController {


    @Autowired
    private LocationRepository locationRepository;

    @GetMapping(value = "/location")
    public GeocodingResult[] getGeoCode() throws InterruptedException, ApiException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyAeL0sH-SHddn-Dq_m0k0vTcuYLEzS2X5M")
                .build();
            GeocodingResult[] results = GeocodingApi.newRequest(context).address(null).await();
            return results;
    }

    @GetMapping(value = "/map")
    public List<Location> getLocation() {
        List<Location> locationMap = locationRepository.findAll();
        return locationMap;
    }



}
// address in de database opslaan

//het address wordt opgeslagen als lat and lng in de database

// de lat/lang wordt gebruikt als markering op de map