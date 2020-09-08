package nl.novi.Sportsapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SporterNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(SporterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String SporterNotFoundHandler(SporterNotFoundException exception){
        return exception.getMessage();
    }
}
