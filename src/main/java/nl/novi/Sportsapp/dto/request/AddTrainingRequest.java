package nl.novi.Sportsapp.dto.request;

import nl.novi.Sportsapp.model.UserSports;

import javax.validation.constraints.NotBlank;


public class AddTrainingRequest {

    public String getActivityId;

    @NotBlank
    private String trainingactivity;

    @NotBlank
    private String nameTrainer;

    @NotBlank
    private String activityName;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    private String zipcode;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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
