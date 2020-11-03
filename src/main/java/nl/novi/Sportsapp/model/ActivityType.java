package nl.novi.Sportsapp.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private long activityTypeId;

    private String activityName;

    @ManyToOne
    private AppUserSport sporters;

    public ActivityType() {

    }

    public ActivityType(String activityName){

    }

    public long getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(long activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setActivityType(AppUserSport appUserSport) {
    }

    public AppUserSport getSporters() {
        return sporters;
    }

    public void setSporters(AppUserSport sporters) {
        this.sporters = sporters;
    }
}
