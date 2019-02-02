package com.wsaults.budget;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  private Float amount;

  private Float max;

  protected Category() {}

  public Category(String name, Float amount, Float max) {
    this.name = name;
    this.amount = amount;
    this.max = max;
  }
}