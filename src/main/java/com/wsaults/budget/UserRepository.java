package com.wsaults.budget;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository {
  User find(Long id);

  User create (User id);

  List<User> list();

  User update(Long id, User user);

  void delete(Long id);
}
