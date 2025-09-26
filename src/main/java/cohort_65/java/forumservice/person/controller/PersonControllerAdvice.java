package cohort_65.java.forumservice.person.controller;

import cohort_65.java.forumservice.person.exception.PersonExistsException;
import cohort_65.java.forumservice.person.exception.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PersonControllerAdvice {

    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(PersonNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(PersonExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleExists(PersonExistsException ex) {
        return ex.getMessage();
    }
}
