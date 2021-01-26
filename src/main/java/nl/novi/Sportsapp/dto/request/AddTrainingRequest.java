package nl.novi.Sportsapp.dto.request;

import nl.novi.Sportsapp.model.UserSports;

import javax.validation.constraints.NotBlank;


public class AddTrainingRequest {

    @NotBlank
    private String trainingactivity;
    @NotBlank
    private String nameTrainer;

    @NotBlank
    private String activityName;
    @NotBlank
    private String location;

    @NotBlank
    private String time;
    @NotBlank
    private String date;

    private UserSports trainer;


    public String getTrainingactivity() {
        return trainingactivity;
    }

    public void setTrainingactivity(String trainingactivity) {
        this.trainingactivity = trainingactivity;
    }

    public String getNameTrainer() {
        return nameTrainer;
    }

    public void setNameTrainer(String nameTrainer) {
        this.nameTrainer = nameTrainer;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public UserSports getTrainer() {
        return trainer;
    }

    public void setTrainer(UserSports trainer) {
        this.trainer = trainer;
    }
}
