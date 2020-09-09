package nl.novi.Sportsapp.exception;

public class UserSportNotFoundException extends RuntimeException {
//    public TrainerNotFoundException(Long trainerId){
//        super("Trainer" + trainerId + "niet gevonden");
//    }

    public UserSportNotFoundException(String errorMessage){
        super(errorMessage);

    }
}
