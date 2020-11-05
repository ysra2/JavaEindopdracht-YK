package nl.novi.Sportsapp.dto.request;

import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.model.UserSports;

import javax.validation.constraints.NotBlank;


public class AddTrainerActivity extends Activity {

    @NotBlank
    private String activityName;

    private UserSports trainer;


    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public UserSports getTrainer() {
            return trainer;
        }

    public void setTrainer(UserSports trainer) {
            this.trainer = trainer;
        }

    public void setActivityId(UserSports sportersFromDb) {
    }
}
