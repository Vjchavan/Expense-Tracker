package com.project.expesetracker.controller;

import com.project.expesetracker.model.Expense;
import com.project.expesetracker.repository.ExpenseRepo;
import com.project.expesetracker.service.ExpenseTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ETController {

    @Autowired
    private ExpenseTrackerService expenseTrackerService;

    @Autowired
    private ExpenseRepo expenseRepo;

    @GetMapping("/home")
    public String getAllExpenses(Model model){
        List<Expense> expense = expenseTrackerService.getAllExpenses();
        model.addAttribute("expense",expense);
        return "index";
    }

    @PostMapping("/")
    public String saveData(@RequestBody Expense expense){
        expenseRepo.save(expense);
        System.out.println("Success");
        return "tp";
    }
}
