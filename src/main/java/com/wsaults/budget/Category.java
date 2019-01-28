package com.wsaults.budget;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public Float getMax() {
    return max;
  }

  public void setMax(Float max) {
    this.max = max;
  }
}