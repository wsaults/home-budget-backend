package com.wsaults.budget;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @RequestMapping("/user")
  public User user(@RequestParam(value="name", defaultValue="test") String name) {
    User user = new User();
    user.setName(name);
    return user;
  }
}