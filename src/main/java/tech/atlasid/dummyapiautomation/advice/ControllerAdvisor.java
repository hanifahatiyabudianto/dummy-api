package tech.atlasid.dummyapiautomation.advice;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tech.atlasid.dummyapiautomation.model.ErrorMessage;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

  @ExceptionHandler({UserNotFoundException.class})
  public ResponseEntity<Object> handleCityNotFoundException(
      UserNotFoundException ex, WebRequest request) {

    ErrorMessage body = ErrorMessage.builder().errorCode("ER-01").message(ex.getMessage())
        .statusCode(HttpStatus.NOT_FOUND.value()).timestamp(LocalDateTime.now()).build();

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({UserAlreadyExistException.class})
  public ResponseEntity<Object> handleUserAlreadyExistException(
      DataMismatchException ex, WebRequest request) {

    ErrorMessage body = ErrorMessage.builder().errorCode("ER-02").message(ex.getMessage())
        .statusCode(HttpStatus.BAD_REQUEST.value()).timestamp(LocalDateTime.now()).build();

    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({DataMismatchException.class})
  public ResponseEntity<Object> handleCityNotFoundException(
      DataMismatchException ex, WebRequest request) {
    ErrorMessage body = ErrorMessage.builder().errorCode("ER-03").message(ex.getMessage())
        .statusCode(HttpStatus.BAD_REQUEST.value()).timestamp(LocalDateTime.now()).build();

    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }

}
