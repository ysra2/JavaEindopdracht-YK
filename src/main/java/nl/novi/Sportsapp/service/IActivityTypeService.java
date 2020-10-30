package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.model.ActivityType;

public interface IActivityTypeService {
    ActivityType updateTrainingById(long trainerId, ActivityType updateTraining);
}
