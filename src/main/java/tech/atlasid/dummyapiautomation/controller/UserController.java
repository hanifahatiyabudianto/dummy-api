package tech.atlasid.dummyapiautomation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.atlasid.dummyapiautomation.model.User;
import tech.atlasid.dummyapiautomation.model.UsersDTO;
import tech.atlasid.dummyapiautomation.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping(value = "", produces = "application/json", name = "get all users")
  public UsersDTO getUsers() {
    return UsersDTO.builder().data(userService.getUsers()).status("success").build();
  }

  @GetMapping(value = "/{id}", produces = "application/json", name = "get user by id")
  public User getUserById(@PathVariable("id") String id) {
    return userService.getUserById(id);
  }

  @DeleteMapping(value = "/{id}", produces = "application/json", name = "delete user by id")
  public void deleteUserById(@PathVariable("id") String id) {
    userService.deleteUser(id);
  }

  @DeleteMapping(value = "/removeAll", produces = "application/json", name = "remove all users")
  public void deleteAlluser() {
    userService.deleteAllUser();
  }

  @PostMapping(value = "", produces = "application/json", consumes = "application/json", name = "add user")
  public User addUsers(@RequestBody User user) {
    return userService.addUser(user);
  }

  @PutMapping(value = "", produces = "application/json", consumes = "application/json", name = "update user")
  public User updateUsers(@RequestBody User user) {
    return userService.updateUser(user);
  }

}
