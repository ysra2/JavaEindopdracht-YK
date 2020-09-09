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

    private String trainingactivity;
    private String infotrainer;
    private String traininglocation;

    @ManyToOne
    private ActivityType activityType;

    @ManyToMany(mappedBy = "activities")
    private List<User> sporters;

    @ManyToOne
    private User trainer;

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public String getTrainingactivity() {
        return trainingactivity;
    }

    public void setTrainingactivity(String trainingactivity) {
        this.trainingactivity = trainingactivity;
    }

    public String getInfotrainer() {
        return infotrainer;
    }

    public void setInfotrainer(String infotrainer) {
        this.infotrainer = infotrainer;
    }

    public String getTraininglocation() {
        return traininglocation;
    }

    public void setTraininglocation(String traininglocation) {
        this.traininglocation = traininglocation;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public List<User> getSporters() {
        return sporters;
    }

    public void setSporters(List<User> sporters) {
        this.sporters = sporters;
    }

    public User getTrainer() {
        return trainer;
    }

    public void setTrainer(User trainer) {
        this.trainer = trainer;
    }
}
