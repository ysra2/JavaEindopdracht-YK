package nl.novi.Sportsapp.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private long activityId;

    private String sportsActivity;

    private String nameTrainer;

    private String location;

    private int time;
    private int date;

    @ManyToOne //1 trainer kan meerdere sportactiviteiten hebben
    private ActivityType activityType;

    @ManyToMany(mappedBy = "activities") // sporters kunnen meerdere activiteiten kiezen
    private List<AppUserSport> sporters;

    @ManyToOne //meerder sporters kunnen trainen bij 1 trainer
    private AppUserSport trainer;


    public Activity(){

    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

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

    public List<AppUserSport> getSporters() {
        return sporters;
    }

    public void setSporters(List<AppUserSport> sporters) {
        this.sporters = sporters;
    }

    public AppUserSport getTrainer() {
        return trainer;
    }

    public void setTrainer(AppUserSport trainer) {
        this.trainer = trainer;
    }

}