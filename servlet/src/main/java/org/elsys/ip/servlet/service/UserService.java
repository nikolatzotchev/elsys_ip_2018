package org.elsys.ip.servlet.service;

import java.util.ArrayList;
import java.util.List;
import org.elsys.ip.servlet.model.User;

public class UserService {

  private static List<User> users = new ArrayList<>();

  public UserService() {
    if (users.size() == 0) {
      users.add(new User(1, "admin", "admin@admin.bg"));
      users.add(new User(2, "user", "user@user.bg"));
    }
  }

  public List<User> getUsers() {
    return users;
  }

  public User getByName(String name) {
    System.out.println(name);
    if (name != null) {
      return users.stream().filter(u -> name.equals(u.getName())).findFirst().orElse(null);
    } else {
      return null;
    }
  }

  public User getById(long id) {
      return users.stream().filter(u -> id == (u.getId())).findFirst().orElse(null);
  }

  public User changeUser(String oldName, String newName, String newMail) {
    getByName(oldName).setName(newName);
    getByName(newName).setEmail(newMail);
    return getByName(newName);
  }

  public void addUser(User user) {
     this.getUsers().add(user);
  }

  public void deleteUser(long id) {
    User user = this.getById(id);
    getUsers().remove(user);
  }
}
