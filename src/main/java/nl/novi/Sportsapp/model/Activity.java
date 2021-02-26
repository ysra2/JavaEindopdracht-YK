package nl.novi.Sportsapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(columnDefinition = "serial")
    private long activityId;

    private String activityName;
    private String nameTrainer;
    private String address;
    private String zipcode;
    private String city;
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


    public Activity(String activityName, String nameTrainer, String address,
                    String zipcode, String city, String time, String date) {
        this.activityName=activityName;
        this.nameTrainer = nameTrainer;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.time = time;
        this.date = date;
    }

    public Activity(long activityId, String activityName, String nameTrainer, String address,
                    String zipcode, String city, String time, String date) {
        this.activityId=activityId;
        this.activityName=activityName;
        this.nameTrainer = nameTrainer;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.time = time;
        this.date = date;
    }

    public Activity(String address, String zipcode, String city) {
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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