package com.wsaults.budget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {

  private HashMap<Long, User> users = new HashMap<>();
  
  @Override
  public User find(Long id) {
    return users.get(id);
  }

  @Override
  public User create(User user) {
    Long id = users.size() + 1L;

    User u = new User(user.getName());

    users.put(id, user);

    return u;
  }

  @Override
  public List<User> list() {
    return new ArrayList<>(users.values());
  }

  @Override
  public User update(Long id, User user) {
    User updateUser = new User (user.getName());

    users.replace(id, updateUser);

    return updateUser;
  }

  @Override
  public void delete(Long id) {
    users.remove(id);
  }
}