package tech.atlasid.dummyapiautomation.advice;

public class DataMismatchException extends RuntimeException {

  public DataMismatchException() {
    super(
        "you must specify data for firstname, lastName, age, occupation, nationality, hobbies (at least 1), and gender");
  }
}
