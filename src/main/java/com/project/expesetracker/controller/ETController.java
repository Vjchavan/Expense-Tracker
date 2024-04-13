package com.project.expesetracker.controller;

import com.project.expesetracker.common.CalculateBalance;
import com.project.expesetracker.common.CalculateExpense;
import com.project.expesetracker.common.CalculateIncome;
import com.project.expesetracker.enums.TransactionType;
import com.project.expesetracker.model.Transactions;
import com.project.expesetracker.repository.TransactionsRepo;
import com.project.expesetracker.service.ExpenseTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ETController {

    @Autowired
    private ExpenseTrackerService expenseTrackerService;

    @Autowired
    private TransactionsRepo transactionsRepo;

    @Autowired
    private CalculateExpense calculateExpense;

    @Autowired
    private CalculateIncome calculateIncome;
    @Autowired
    private CalculateBalance calculateBalance;

    @GetMapping("/home")
    public String getAllExpenses(Model model){
        List<Transactions> expense = expenseTrackerService.getAllExpenses();
        model.addAttribute("expense",expense);
        model.addAttribute("expenseAmount",calculateExpense.calculateExpense());
        model.addAttribute("incomeAmount",calculateIncome.calculateIncome());
        model.addAttribute("balance",calculateBalance.calculateBalance());
        return "index";
    }


    @GetMapping("/income")
    public String showIncomePage() {
        return "income";
    }

    @GetMapping("/expense")
    public String showExpensePage() {
        return "expense";
    }

    @GetMapping("/analytics")
    public String showAnalyticsPage(Model model) {
        List<Transactions> transactions = transactionsRepo.findAll();
        List<String> expensecategory = transactions.stream().filter(x->x.getTransactionType().equals(TransactionType.EXPENSE)).map(x-> x.getCategory()).distinct().collect(Collectors.toList());
        List<String> incomecategory = transactions.stream().filter(x->x.getTransactionType().equals(TransactionType.INCOME)).map(x-> x.getCategory()).distinct().collect(Collectors.toList());
        List<Double> expense = transactions.stream().filter(x->x.getTransactionType().equals(TransactionType.EXPENSE)).map(x->x.getAmount()).collect(Collectors.toList());
        List<Double> income = transactions.stream().filter(x->x.getTransactionType().equals(TransactionType.INCOME)).map(x->x.getAmount()).collect(Collectors.toList());
        model.addAttribute("expensecategory",expensecategory);
        model.addAttribute("incomecategory",incomecategory);
        model.addAttribute("expense",expense);
        model.addAttribute("income",income);
        return "pieChart";
    }

    @PostMapping("/register")
    public String addTransaction(@ModelAttribute Transactions transactions){
        System.out.println("Date:"+transactions.getExpenseDate());
        expenseTrackerService.saveTransaction(transactions);
        return "redirect:/home";
    }
}
