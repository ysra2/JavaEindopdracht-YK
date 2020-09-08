package nl.novi.Sportsapp.exception;

public class SporterNotFoundException extends RuntimeException {
    public SporterNotFoundException(Long sporterId){
        super("Sporter" + sporterId + "niet gevonden");
    }
}

