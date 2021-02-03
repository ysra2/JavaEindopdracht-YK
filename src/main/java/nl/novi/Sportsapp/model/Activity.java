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

    @Column(columnDefinition = "serial")
    private long activityId;

    private String activityName;
    private String nameTrainer;
    private String location;

    private String time;
    private String date;


    @JsonIgnore
    @ManyToMany(mappedBy = "activities", fetch = FetchType.LAZY)
    private List<UserSports> sporters;

    @ManyToOne
    @JsonIgnore
    private UserSports trainer;

    public Activity() {
    }

    public Activity(String activityName, String nameTrainer, String location, String time, String date) {
        this.activityName=activityName;
        this.nameTrainer = nameTrainer;
        this.location = location;
        this.time = time;
        this.date = date;
    }

    public Activity(long activityId, String activityName, String nameTrainer, String location, String time, String date) {
        this.activityId=activityId;
        this.activityName=activityName;
        this.nameTrainer = nameTrainer;
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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
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