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

    @ManyToOne(fetch = FetchType.EAGER)
    private Sporter training;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personaltrainer")
    private List<Trainer> trainers;

    public Activity(){

    }

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

    public Sporter getTraining() {
        return training;
    }

//    public void setTraining(Trainer training) {
//        this.training = training;
//    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public void setSporters(Trainer trainerFromDb) {
    }
}
