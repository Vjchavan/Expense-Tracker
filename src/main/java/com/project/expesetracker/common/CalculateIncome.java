package com.project.expesetracker.common;

import com.project.expesetracker.enums.TransactionType;
import com.project.expesetracker.model.Transactions;
import com.project.expesetracker.repository.TransactionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalculateIncome {

    @Autowired
    private TransactionsRepo repo;

    public CalculateIncome() {
    }

    public double calculateIncome(){
        List<Transactions> transactions = repo.findByTransactionType(TransactionType.INCOME);
        double income = transactions.stream()
                        .mapToDouble(Transactions::getAmount).sum();
        return income;
    }

}
