package tech.atlasid.dummyapiautomation.advice;

public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException() {
    super("user not found");
  }
}
