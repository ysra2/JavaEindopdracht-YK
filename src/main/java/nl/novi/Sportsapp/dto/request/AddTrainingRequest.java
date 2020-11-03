package nl.novi.Sportsapp.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import nl.novi.Sportsapp.model.AppUserSport;

import javax.validation.constraints.NotBlank;

@JsonIgnoreProperties
public class AddTrainingRequest {

    @NotBlank
    private String trainingactivity;
    private String nameTrainer;

    @NotBlank
    private String location;

    @NotBlank
    private int time;
    private int date;

    private AppUserSport trainer;


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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public AppUserSport getTrainer() {
        return trainer;
    }

    public void setTrainer(AppUserSport trainer) {
        this.trainer = trainer;
    }
}
