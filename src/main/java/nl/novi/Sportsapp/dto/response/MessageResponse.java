package nl.novi.Sportsapp.dto.response;

public class MessageResponse {

    private String message;

    private MessageResponse(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
