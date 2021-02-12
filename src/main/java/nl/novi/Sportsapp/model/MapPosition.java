package nl.novi.Sportsapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class MapPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")

    @Column(columnDefinition = "serial")
    private long mapId;

    private double latitude;
    private double longitude;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Activity> locations;

    @ManyToOne
    @JsonIgnore
    private Activity mapLocation;

    public MapPosition(){

    }

    public MapPosition(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public MapPosition(long mapId, double latitude, double longitude) {
        this.mapId = mapId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<Activity> getLocations() {
        return locations;
    }

    public void setLocations(List<Activity> locations) {
        this.locations = locations;
    }

    public Activity getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(Activity mapLocation) {
        this.mapLocation = mapLocation;
    }

    @Override
    public String toString() {
        return "MapPosition{" +
                "mapId=" + mapId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
