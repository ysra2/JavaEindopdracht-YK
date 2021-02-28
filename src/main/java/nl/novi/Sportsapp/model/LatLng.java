//package nl.novi.Sportsapp.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.google.maps.internal.StringJoin;
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.List;
//import java.util.Locale;
//import java.util.Objects;
//
//@Entity
//public class LatLng extends com.google.maps.model.LatLng implements StringJoin.UrlValue, Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
//    @GenericGenerator(name = "native", strategy = "native")
//
//    @Column(columnDefinition = "serial")
//    private long mapId;
//
//    private double lat;
//    private double lng;
//
//    @JsonIgnore
//    @ManyToMany(fetch = FetchType.LAZY)
//    private List<Activity> locations;
//
//    @ManyToOne
//    @JsonIgnore
//    private Activity mapLocation;
//
//    public LatLng(){
//
//    }
//
//    public LatLng(double lat, double lng) {
//        this.lat = lat;
//        this.lng = lng;
//    }
//
//    public LatLng(long mapId, double lat, double lng) {
//        this.mapId = mapId;
//        this.lat = lat;
//        this.lng = lng;
//    }
//
//
//    public long getMapId() {
//        return mapId;
//    }
//
//    public double getLat() {
//        return lat;
//    }
//
//    public void setLat(double lat) {
//        this.lat = lat;
//    }
//
//    public double getLng() {
//        return lng;
//    }
//
//    public void setLng(double lng) {
//        this.lng = lng;
//    }
//
//    public List<Activity> getLocations() {
//        return locations;
//    }
//
//    public void setLocations(List<Activity> locations) {
//        this.locations = locations;
//    }
//
//    public Activity getMapLocation() {
//        return mapLocation;
//    }
//
//    public void setMapLocation(Activity mapLocation) {
//        this.mapLocation = mapLocation;
//    }
//
//    @Override
//    public String toString() {
//        return toUrlValue();
//    }
//
//    @Override
//    public String toUrlValue() {
//        return String.format(Locale.ENGLISH, "%.8f,%.8f", lat, lng);
//    }
//
//    @Override
//    public boolean equals(Object o){
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        LatLng latLng = (LatLng) o;
//        return Double.compare(latLng.lat, lat) == 0 && Double.compare(latLng.lng, lng) == 0;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(lat, lng);
//    }
//}
