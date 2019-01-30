package com.wsaults.budget;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class CategoryController {
  private CategoryRepository categoryRepository;

  public CategoryController(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @RequestMapping(value="/categories", method=RequestMethod.GET)
  public @ResponseBody Iterable<Category> requestMethodName() {
      return this.categoryRepository.findAll();
  }
}