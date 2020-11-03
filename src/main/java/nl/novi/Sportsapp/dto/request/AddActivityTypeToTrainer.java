package nl.novi.Sportsapp.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import nl.novi.Sportsapp.model.AppUserSport;
import javax.validation.constraints.NotBlank;

@JsonIgnoreProperties
public class AddActivityTypeToTrainer {

        @NotBlank
        private String activityName;

        private AppUserSport trainer;


    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public AppUserSport getTrainer() {
            return trainer;
        }

        public void setTrainer(AppUserSport trainer) {
            this.trainer = trainer;
        }

}
