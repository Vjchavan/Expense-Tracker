package com.project.expesetracker.controller;

import com.project.expesetracker.common.CalculateExpense;
import com.project.expesetracker.model.Transactions;
import com.project.expesetracker.repository.ExpenseRepo;
import com.project.expesetracker.service.ExpenseTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ETController {

    @Autowired
    private ExpenseTrackerService expenseTrackerService;

    @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private CalculateExpense calculateExpense;

    @GetMapping("/home")
    public String getAllExpenses(Model model){
        List<Transactions> expense = expenseTrackerService.getAllExpenses();
        model.addAttribute("expense",expense);
        model.addAttribute("expenseAmount",calculateExpense.calculateExpense());
        return "index";
    }

    @PostMapping("/")
    public String saveData(@RequestBody Transactions expense){
        expenseRepo.save(expense);
        System.out.println("Success");
        return "tp";
    }
}
