package nl.novi.Sportsapp.dto.request;

import nl.novi.Sportsapp.model.UserSports;

import javax.validation.constraints.NotBlank;


public class AddTrainingRequest {

    @NotBlank
    private String activityName;

    @NotBlank
    private String trainerName;

    @NotBlank
    private String location;

    @NotBlank
    private String dateTime;

    private UserSports trainer;


    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public UserSports getTrainer() {
        return trainer;
    }

    public void setTrainer(UserSports trainer) {
        this.trainer = trainer;
    }
}
