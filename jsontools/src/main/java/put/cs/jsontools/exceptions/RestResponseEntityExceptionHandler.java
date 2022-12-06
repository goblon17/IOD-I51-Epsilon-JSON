package put.cs.jsontools.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = InvalidJsonFormatException.class)
    public ResponseEntity<Object> handleInvalidJsonFormatException(InvalidJsonFormatException exception){
        return new ResponseEntity<Object>("Not working JSON input", new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = FieldInJsonNotFoundException.class)
    public ResponseEntity<Object> handleFieldInJsonNotFoundException(FieldInJsonNotFoundException exception){
        return new ResponseEntity<Object>("Field not found in JSON input", new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }

}
