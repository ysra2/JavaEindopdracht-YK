package nl.novi.Sportsapp.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private long activityTypeId;

    private String name;

    public long getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(long activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
