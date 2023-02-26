package com.izzy.save_travels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.izzy.save_travels.models.Expense;
import com.izzy.save_travels.services.ExpenseService;



@Controller
public class ExpenseController {

  @Autowired
  ExpenseService expenseService;

  // (in this case Read All & Create are on the same page)
  // ============ READ ALL ============
  // (usually the root of the application)
  // ============ CREATE ============
  // (need 2 Routes - to Render & Post)
  // vvvvvvv RENDER vvvvvvv
  @GetMapping("/")
  public String index(@ModelAttribute("expense") Expense expense, Model model) {
    List<Expense> expenses = expenseService.allExpenses();
    model.addAttribute("expenses", expenses);
    return "index.jsp";
  }

  // vvvvvvv POST vvvvvvv
  @PostMapping("/expenses")
  public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
    if (result.hasErrors()) {
      return "index.jsp";
    } else {
      expenseService.createExpense(expense);
      return "redirect:/";
    }
  }

  // ============ UPDATE ============
  // (need 2 Routes - to Render & Post)
  // vvvvvvv RENDER vvvvvvv
  @GetMapping("expenses/edit/{id}")
  public String edit(@PathVariable("id") Long id, Model model) {
    Expense expense = expenseService.findExpense(id);
    model.addAttribute("expense", expense);
    return "/edit.jsp";
  }
  
  // vvvvvvv POST vvvvvvv
  @PostMapping("/expenses/{id}")
  public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
    if (result.hasErrors()) {
      return "/edit.jsp";
    } else {
      expenseService.updateExpense(expense);
    }
    return "redirect:/";
  }
  
  // ============ DELETE ============
  @DeleteMapping("/expenses/{id}")
  public String destroy(@PathVariable("id") Long id) {
    expenseService.deleteExpense(id);
    return "redirect:/";
  }
  
  // =========== READ ONE ===========
  @GetMapping("expenses/show/{id}")
  public String show(@PathVariable("id") Long id, Model model) {
    Expense expense = expenseService.findExpense(id);
    model.addAttribute("expense", expense);
    return "/show.jsp";
  }

}
