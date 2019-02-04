package com.wsaults.budget;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

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

  @RequestMapping(value="/category/{id}", method=RequestMethod.GET)
  public @ResponseBody Optional<Category> requestMethodName(@PathVariable("id") long id) {
    return this.categoryRepository.findById(id);
  }

  @RequestMapping(
    value="/category/{id}/addExpense/{amount}",
    method=RequestMethod.POST)
  public @ResponseBody Optional<Category> postExpenseToCategory(
    @PathVariable("id") long id,
    @PathVariable("amount") float amount) {
    Optional<Category> category = this.categoryRepository.findById(id);

    if (category.isPresent()) {
      Category c = category.get();
      c.setAmount(c.getAmount() + amount);
      this.categoryRepository.save(c);
    }

    return category;
  }
}