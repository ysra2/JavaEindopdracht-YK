package nl.novi.Sportsapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private long activityId;

    private String activityName;
    private String trainerName;
    private String location;
    private String dateTime;


    @JsonIgnore
    @ManyToMany(mappedBy = "activities", fetch = FetchType.LAZY)
    private List<UserSports> sporters;

    @ManyToOne
    @JsonIgnore
    private UserSports trainer;

    public Activity() {
    }

    public Activity(String activityName, String trainerName, String location, String dateTime) {
        this.activityName = activityName;
        this.trainerName = trainerName;
        this.location = location;
        this.dateTime = dateTime;
    }

    public long getActivityId() {
        return activityId;
    }


    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

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

    public List<UserSports> getSporters() {
        return sporters;
    }

    public void setSporters(List<UserSports> sporters) {
        this.sporters = sporters;
    }

    public UserSports getTrainer() {
        return trainer;
    }

    public void setTrainer(UserSports trainer) {
        this.trainer = trainer;
    }




}