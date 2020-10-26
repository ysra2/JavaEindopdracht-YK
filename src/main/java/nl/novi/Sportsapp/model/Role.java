package nl.novi.Sportsapp.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(columnDefinition = "serial")
    private long userId;

    @Enumerated(EnumType.STRING) //de vaste waardes zijn in deze situatie de trainer/sporter(/admin)
    // er moet een onderscheid komen tussen de twee rollen anders heeft de app zijn functie niet
    private ERole name;

    public Role(){

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
