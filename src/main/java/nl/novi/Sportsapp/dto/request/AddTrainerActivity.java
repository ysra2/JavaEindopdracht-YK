package nl.novi.Sportsapp.dto.request;

import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.model.UserSports;

import javax.validation.constraints.NotBlank;


public class AddTrainerActivity extends Activity {

    @NotBlank
    private String activityName;
    private String location;

    @NotBlank
    private int time;
    private int date;

    private UserSports trainer;



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


    public UserSports getTrainer() {
        return trainer;
    }


    public void setTrainer(UserSports trainer) {
        this.trainer = trainer;
    }

    public void setActivityId(UserSports sportersFromDb) {
    }

}
