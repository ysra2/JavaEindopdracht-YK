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
        private String location;

        @ManyToOne
        private ActivityType activityType;

        @ManyToMany(mappedBy = "activities")
        private List<AppUserSport> sporters;

        @ManyToOne
        private AppUserSport trainer;

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

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
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