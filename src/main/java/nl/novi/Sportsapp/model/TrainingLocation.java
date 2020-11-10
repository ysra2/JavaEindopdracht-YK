//package nl.novi.Sportsapp.model;
//
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//
//@Entity
//public class TrainingLocation {
//    @Id
//    @GeneratedValue(
//            strategy = GenerationType.AUTO,
//            generator = "native"
//    )
//    @GenericGenerator(
//            name = "native",
//            strategy = "native"
//    )
//    @Column(columnDefinition = "serial")
//    private long id;
//
//    private Long lat;
//    private Long lng;
//
//    @ManyToOne
//    private Activity activity;
//
//    public TrainingLocation(Long lat, Long lng, Activity activity) {
//        this.lat = lat;
//        this.lng = lng;
//        this.activity = activity;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public Long getLat() {
//        return lat;
//    }
//
//    public void setLat(Long lat) {
//        this.lat = lat;
//    }
//
//    public Long getLng() {
//        return lng;
//    }
//
//    public void setLng(Long lng) {
//        this.lng = lng;
//    }
//
//    public Activity getActivity() {
//        return activity;
//    }
//
//    public void setActivity(Activity activity) {
//        this.activity = activity;
//    }
//}
