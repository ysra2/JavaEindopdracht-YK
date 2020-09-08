package nl.novi.Sportsapp.controller;

import nl.novi.Sportsapp.repository.ActivityRepository;
import nl.novi.Sportsapp.repository.SporterRepository;
import nl.novi.Sportsapp.repository.TrainerRepository;
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
