package nl.novi.Sportsapp.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddTrainingRequest {

    @NotBlank
    @Size(min = 3)
    private String sportsActivity;
    private String nameTrainer;

    @NotBlank
    @Size(min = 3)
    private String address;

    @NotBlank
    private int time;
    private int date;


    public String getSportsActivity() {
        return sportsActivity;
    }

    public void setSportsActivity(String sportsActivity) {
        this.sportsActivity = sportsActivity;
    }
    public String getNameTrainer() {
        return nameTrainer;
    }

    public void setNameTrainer(String nameTrainer) {
        this.nameTrainer = nameTrainer;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}