package nl.novi.Sportsapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

//(DTO)data transfer objecten zijn klasse/objecten die communiceren met de datalagen binnen de applicatie
// kan front &back zijn of tussen servicelagen

@Entity
@Table(name = "app_user_sport")
public class UserSports {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    @Column(columnDefinition = "serial")
    private long userId;
    //private zorgt ervoor dat het alleen toegankelijk is voor de desbetreffende klasse
    private String firstName;
    private String lastName;

    private String username;
    private String email;
    private String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //verschillende activiteiten hebben ook verschillende trainers
    @JoinTable
            (name = "sporter_activity",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id"))
    private List<Activity> activities ;

    @JsonIgnoreProperties
    //omdat de relatie bi-rationeel is zorgt deze annotatie ervoor dat
    // deze functie maar 1 keer geroepen wordt en niet oneindig
    @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY)
    //1 trainer kan meerdere soorten sportactiviteiten hebben/toevoegen
    private List<Activity> activitiesAsTrainer;

    @ManyToMany // user heeft verschillende rollen en en rol heeft verschillende users
    @JoinTable (name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public UserSports() {

    }

    public UserSports(String firstName, String lastName, String username, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getUsername() {
        return email;
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

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Activity> getActivitiesAsTrainer() {
        return activitiesAsTrainer;
    }

    public void setActivitiesAsTrainer(List<Activity> activitiesAsTrainer) {
        this.activitiesAsTrainer = activitiesAsTrainer;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}