package cohort_65.java.forumservice.person.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PersonExistsException extends RuntimeException {
    public PersonExistsException(String message) {
        super(message);
    }
}
