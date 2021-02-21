package tech.atlasid.dummyapiautomation.advice;

public class UserAlreadyExistException extends RuntimeException {

  public UserAlreadyExistException() {
    super("user already exists");
  }
}
