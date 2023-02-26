// (THE SERVICE UTILIZES THE REPOSITORY)
// This is where we put all the CRUD methods

package com.izzy.save_travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izzy.save_travels.models.Expense;
import com.izzy.save_travels.repositories.ExpenseRepository;


@Service // <-- tells Spring this is a service

public class ExpenseService {

  // connect to the repository to access built-in methods
  @Autowired
  ExpenseRepository expenseRepository;

  // ========== READ ALL ==========
  public List<Expense> allExpenses() {
    return expenseRepository.findAll();
  }

  // =========== CREATE ===========
  public Expense createExpense(Expense expense) {
    return expenseRepository.save(expense);
  }

  // ========== FIND BY ID ==========
  public Expense findExpense(Long id) {
    // use Optional in case the expense doesn't exist
    Optional<Expense> optionalExpense = expenseRepository.findById(id);
    if (optionalExpense.isPresent()) {
      return optionalExpense.get();
    } else {
      return null;
    }
  }

  // =========== UPDATE ===========
  // (exactly the same as create)
  public Expense updateExpense(Expense expense) {
    return expenseRepository.save(expense);
  }
  
  // =========== DELETE ===========
  public void deleteExpense(Long id) {
    expenseRepository.deleteById(id);
  }

}
