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

  private String iconName;

  protected Category() {}

  public Category(String name, Float amount, Float max, String iconName) {
    this.name = name;
    this.amount = amount;
    this.max = max;
    this.iconName = iconName;
  }

  public long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Float getAmount() {
    return this.amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public Float getMax() {
    return this.max;
  }

  public void setMax(Float max) {
    this.max = max;
  }
  
  public String getIconName() {
    return this.iconName;
  }

  public void setIconName(String iconName) {
    this.iconName = iconName;
  }
}