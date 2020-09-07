package nl.novi.Sportsapp.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private long trainerId;

    private String name;
    private String username;
    private int phonenumber;
    private String email;
    private String password;


    @ManyToOne(fetch = FetchType.LAZY)
    private Activity personaltrainer;

    public Trainer(){

    }

    public long getTrainId() {
        return trainerId;
    }

    public void setTrainId(long trainId) {
        this.trainerId = trainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Activity getPersonaltrainer() {
        return personaltrainer;
    }

    public void setPersonaltrainer(Activity personaltrainer) {
        this.personaltrainer = personaltrainer;
    }
}
