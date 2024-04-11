package com.project.expesetracker.common;

import com.project.expesetracker.enums.TransactionType;
import com.project.expesetracker.model.Transactions;
import com.project.expesetracker.repository.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CalculateExpense {

    @Autowired
    private ExpenseRepo expenseRepo;

    public double calculateExpense(){
    List<Transactions> transactions = expenseRepo.findByTransactionType(TransactionType.EXPENSE);
        double finalExpense = transactions.stream()
                .mapToDouble(Transactions::getAmount).sum();

        return finalExpense;
    }


}
