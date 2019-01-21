package com.wsaults.budget;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  private UserRepository userRepository;
  
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping
  public ResponseEntity create(@RequestBody User user) {
    User createdUser = userRepository.create(user);
    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
  }

  @GetMapping("{id}")
  public ResponseEntity<User> read(@PathVariable long id) {
    User user = userRepository.find(id);

    if (user == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<User>> list() {
    return new ResponseEntity<>(userRepository.list(), HttpStatus.OK);
  }

  @PutMapping("{id}")
  public ResponseEntity update (@PathVariable long id, @RequestBody User user) {
    User updateUser = userRepository.update(id, user);

    if (updateUser == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updateUser, HttpStatus.OK);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<User> delete(@PathVariable long id) {
    userRepository.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}