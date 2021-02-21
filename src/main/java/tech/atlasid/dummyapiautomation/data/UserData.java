package tech.atlasid.dummyapiautomation.data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Data;
import org.springframework.stereotype.Component;
import tech.atlasid.dummyapiautomation.model.User;

@Data
@Component("tech.atlasid.dummyapiautomation.data.UserData")
public class UserData {

  private List<User> users = new ArrayList<>();

  public User getUser(String id) {
    Optional<User> data = users.stream().filter(user -> user.getId().equals(id))
        .findFirst();
    return data.orElse(null);
  }

  public boolean checkUserExists(String id) {
    if (id != null && users.stream().anyMatch(u -> u.getId().equals(id))) {
      return true;
    }
    return false;
  }

  public User addUser(User user) {
    if (!checkUserExists(user.getId())) {
      user.setCreatedDate(LocalDateTime.now());
      user.setUpdatedDate(null);
      if (users.size() >= 100) {
        users.remove(0);
      }
      this.users.add(user);
      return user;
    }
    return null;
  }

  public User updateUser(User user) {
    if (checkUserExists(user.getId())) {
      User tempUser = getUser(user.getId());
      user.setCreatedDate(tempUser.getCreatedDate());
      users.remove(tempUser);
      user.setUpdatedDate(LocalDateTime.now());
      users.add(user);
      return user;
    }
    return null;
  }

  public boolean deleteUser(String id) {
    if (checkUserExists(id)) {
      User user = getUser(id);
      users.remove(user);
      return true;
    }
    return false;
  }

  public void deleteAllUser() {
    this.users.clear();
  }
}
