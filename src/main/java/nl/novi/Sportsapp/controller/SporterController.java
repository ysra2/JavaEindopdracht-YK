package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.service.ActivityRepository;
import nl.novi.Sportsapp.service.SporterRepository;
import nl.novi.Sportsapp.service.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SporterController {

    @Autowired //deze wordt gekoppeld met de service klasse
    private TrainerRepository trainerRepository;

    @Autowired
    private SporterRepository sporterRepository;

    @Autowired
    private ActivityRepository activityRepository;


}
