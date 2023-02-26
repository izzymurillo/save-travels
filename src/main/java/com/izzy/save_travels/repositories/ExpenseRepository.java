package com.izzy.save_travels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.izzy.save_travels.models.Expense;


// ... (THE REPOSITORY CONNECTS TO THE DATABASE)

@Repository // <--tells Spring this is a repository

// create an interface that extends the CrudRepository (allows all CRUD
// operations)
public interface ExpenseRepository extends CrudRepository<Expense, Long> { // (Long = id)

  // this method retrieves all expenses from the database
  List<Expense> findAll();

}
