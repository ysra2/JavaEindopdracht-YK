package nl.novi.Sportsapp.exception;

public class UserSportNotFoundException extends RuntimeException {


    public UserSportNotFoundException(long id){
        super("User"+ " " + id + " " + " not found");

    }

    public UserSportNotFoundException(String errorMessage){
        super(errorMessage);

    }
}
