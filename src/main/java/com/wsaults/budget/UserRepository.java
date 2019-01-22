package com.wsaults.budget;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

  List<User> findByName(String name);
  // User find(Long id);

  // User create (User id);

  // List<User> list();

  // User update(Long id, User user);

  // void delete(Long id);
}
