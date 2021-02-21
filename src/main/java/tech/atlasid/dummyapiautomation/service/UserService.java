package tech.atlasid.dummyapiautomation.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import tech.atlasid.dummyapiautomation.advice.DataMismatchException;
import tech.atlasid.dummyapiautomation.advice.UserAlreadyExistException;
import tech.atlasid.dummyapiautomation.advice.UserNotFoundException;
import tech.atlasid.dummyapiautomation.data.UserData;
import tech.atlasid.dummyapiautomation.model.User;

@Service
public class UserService {

  private final UserData userData;

  public UserService(UserData userData) {
    this.userData = userData;
  }

  public List<User> getUsers() {
    return userData.getUsers();
  }

  public User getUserById(String id) {
    return Optional.ofNullable(userData.getUser(id))
        .orElseThrow(UserNotFoundException::new);
  }

  public User addUser(User user) {
    validateData(user);
    user.setId(UUID.randomUUID().toString());
    return Optional.ofNullable(userData.addUser(user))
        .orElseThrow(UserAlreadyExistException::new);
  }

  public void validateData(User user) {
    if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
      throw new DataMismatchException();
    }
    if (user.getLastName() == null || user.getLastName().isEmpty()) {
      throw new DataMismatchException();
    }
    if (user.getAge() == null || user.getAge() <= 0) {
      throw new DataMismatchException();
    }
    if (user.getOccupation() == null || user.getOccupation().isEmpty()) {
      throw new DataMismatchException();
    }
    if (user.getNationality() == null || user.getNationality().isEmpty()) {
      throw new DataMismatchException();
    }
    if (user.getGender() == null) {
      throw new DataMismatchException();
    }
    if (user.getHobbies() == null || user.getHobbies().isEmpty()) {
      throw new DataMismatchException();
    }
  }

  public User updateUser(User user) {
    validateData(user);
    return Optional.ofNullable(userData.updateUser(user))
        .orElseThrow(UserNotFoundException::new);
  }

  public void deleteUser(String id) {
    if (!userData.deleteUser(id)) {
      throw new UserNotFoundException();
    }
  }

  public void deleteAllUser() {
    userData.deleteAllUser();
  }
}

