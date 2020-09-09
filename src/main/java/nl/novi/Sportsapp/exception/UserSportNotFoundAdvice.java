package nl.novi.Sportsapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserSportNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(UserSportNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String SporterNotFoundHandler(UserSportNotFoundException exception){
        return exception.getMessage();
    }
}
