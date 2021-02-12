//package nl.novi.Sportsapp.dto.request;
//
//import nl.novi.Sportsapp.service.ActivityService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//
//public class DataBaseFillerActivity implements CommandLineRunner {
//    private final ActivityService activityService;
//
//
//    @Autowired
//    DataBaseFillerActivity(ActivityService activityService) {
//        this.activityService = activityService;
//    }
//
//    public void run(String...args){
//        AddTrainingRequest activity = new AddTrainingRequest();
//        activity.setActivityName("Boksen");
//        activity.setNameTrainer("Jan");
//        activity.setLocation("Philips de Jong Park, Eindhoven");
//        activity.setTime("12:00");
//        activity.setDate("28-02-2021");
//    }
//}
