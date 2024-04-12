package com.project.expesetracker.common;

import com.project.expesetracker.enums.TransactionType;
import com.project.expesetracker.model.Transactions;
import com.project.expesetracker.repository.TransactionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CalculateExpense {

    @Autowired
    private TransactionsRepo transactionsRepo;

    public double calculateExpense(){
    List<Transactions> transactions = transactionsRepo.findByTransactionType(TransactionType.EXPENSE);
        double finalExpense = transactions.stream()
                .mapToDouble(Transactions::getAmount).sum();

        return finalExpense;
    }


}
