package nl.novi.Sportsapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

//(DTO)data transfer objecten zijn klasse/objecten die communiceren met de datalagen binnen de applicatie
// kan front &back zijn of tussen servicelagen

@Entity
@Table(name = "app_user_sport")
public class AppUserSport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(columnDefinition = "serial")
    private long userId;
    //private zorgt ervoor dat het alleen toegankelijk is voor de desbetreffende klasse
    private String firstname;
    private String lastname;

    private String username;
    private String email;
    private String password;
    private String password2;

    @ManyToMany //verschillende activitieten hebben ook verschillende trainers
    @JoinTable(name = "sporter_activity",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id"))
    private List<Activity> activities;

    @JsonIgnoreProperties
    //omdat de relatie bi-rationeel is zorgt deze annotatie ervoor dat
    // deze functie maar 1 keer geroepen wordt en niet oneindig
    @OneToMany(mappedBy = "trainer") //1 trainer kan meerdere soorten sportactiviteiten hebben/toevoegen
    private List<Activity> activiesAsTrainer;

    @ManyToMany // user heeft verschillende rollen en en rol heeft verschillende users
    @JoinTable (name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public AppUserSport() {

    }

    public AppUserSport(String firstname, String lastname, String username, String email, String password, String password2) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.password2 = password2;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getPassword2() {
        return password;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Activity> getActiviesAsTrainer() {
        return activiesAsTrainer;
    }

    public void setActiviesAsTrainer(List<Activity> activiesAsTrainer) {
        this.activiesAsTrainer = activiesAsTrainer;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}