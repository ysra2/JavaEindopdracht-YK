package nl.novi.Sportsapp.dto.response;

public class AddActivityResponse {

    private String addActivity;

    public AddActivityResponse(String addActivity) {
        this.addActivity = addActivity;
    }

    public String getAddActivityResponse() {
        return addActivity;
    }

    public void setAddActivityResponse(String addActivityResponse) {
        this.addActivity = addActivityResponse;
    }
}
