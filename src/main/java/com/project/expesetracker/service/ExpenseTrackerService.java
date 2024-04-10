package com.project.expesetracker.service;

import com.project.expesetracker.model.Transactions;
import com.project.expesetracker.repository.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseTrackerService {

    @Autowired
    private ExpenseRepo expenseRepo;
    public List<Transactions> getAllExpenses() {
        List<Transactions> result = expenseRepo.findAll();
        return result;
    }
}
