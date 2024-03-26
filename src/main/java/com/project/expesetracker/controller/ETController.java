package com.project.expesetracker.controller;

import com.project.expesetracker.model.Expense;
import com.project.expesetracker.service.ExpenseTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ETController {

    @Autowired
    private ExpenseTrackerService expenseTrackerService;

    @GetMapping("/home")
    public String getAllExpenses(Model model){
        List<Expense> expense = expenseTrackerService.getAllExpenses();
        model.addAttribute("expense",expense);
        return "index";
    }

}
