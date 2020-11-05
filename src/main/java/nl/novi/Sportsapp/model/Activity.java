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

    private String location;

    private int time;
    private int date;


    @ManyToOne
    @JsonIgnore
    private ActivityType activityType;

    @JsonIgnore
    @ManyToMany(mappedBy = "activities", fetch = FetchType.LAZY)
    private List<UserSports> sporters;

    @ManyToOne
    @JsonIgnore
    private UserSports trainer;

    public Activity() {
    }

    public Activity(String location, int time, int date) {
        this.location = location;
        this.time = time;
        this.date = date;
    }

    public long getActivityId() {
        return activityId;
    }


    public void setActivityId(long activityId) {
        this.activityId = activityId;
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

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
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