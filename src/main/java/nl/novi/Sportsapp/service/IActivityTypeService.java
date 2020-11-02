package nl.novi.Sportsapp.service;

import nl.novi.Sportsapp.dto.request.AddActivityTypeToTrainer;
import nl.novi.Sportsapp.model.ActivityType;

public interface IActivityTypeService {
    ActivityType updateTrainingById(long trainerId, ActivityType updateTraining, AddActivityTypeToTrainer addActivityTypeToTrainer);
}
