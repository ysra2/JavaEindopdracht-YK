package nl.novi.Sportsapp.exception;

public class TrainerNotFoundException extends RuntimeException {
//    public TrainerNotFoundException(Long trainerId){
//        super("Trainer" + trainerId + "niet gevonden");
//    }

    public TrainerNotFoundException (String errorMessage){
        super(errorMessage);

    }
}
