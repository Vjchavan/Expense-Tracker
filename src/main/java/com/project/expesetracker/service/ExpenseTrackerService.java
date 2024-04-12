package com.project.expesetracker.service;

import com.project.expesetracker.model.Transactions;
import com.project.expesetracker.repository.TransactionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseTrackerService {

    @Autowired
    private TransactionsRepo transactionsRepo;

    public List<Transactions> getAllExpenses() {
        List<Transactions> result = transactionsRepo.findAll();
        return result;
    }

    public void saveTransaction(Transactions transactions) {
        transactionsRepo.save(transactions);
    }
}
