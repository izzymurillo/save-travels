package com.izzy.save_travels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity // <--represents an entity model for our app
@Table(name = "burgers") // <--sets this as a table in the database

public class Expense {

  @Id // <--sets this as the primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // <--sets this as an auto-incrementing value
  private Long id;

  @NotNull // <--adds validation that the column must not be null
  @Size(min = 3, max = 50, message = " Expense name must be at least 3 characters.") // <--adds validation that the column must be in the specified range
  private String name;

  @NotNull
  @Size(min = 2, max = 50, message = " Vendor name must be at least 2 characters.")
  private String vendor;

  @NotNull
  private float amount;

  @NotNull
  @Size(min = 2, max = 200, message = " Description name must be at least 2 characters.")
  private String description;

  // This will not allow the createdAt column to be updated after creation
  @Column(updatable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createdAt;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updatedAt;

  public Expense() { // <--(empty constructor)
  }

  public Expense(String name, String vendor, float amount, String description) {
    this.name = name;
    this.vendor = vendor;
    this.amount = amount;
    this.description = description;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getVendor() {
    return this.vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  public float getAmount() {
    return this.amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @PrePersist // <-- runs the method right before the object is created
  protected void onCreate() {
    this.createdAt = new Date();
  }

  @PreUpdate // <--runs a method when the object is modified
  protected void onUpdate() {
    this.updatedAt = new Date();
  }

}
