package com.project.expesetracker.common;

import com.project.expesetracker.enums.TransactionType;
import com.project.expesetracker.model.Transactions;
import com.project.expesetracker.repository.ExpenseRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CalculateExpense {

    private final ExpenseRepo repo;

    @Autowired
    public CalculateExpense(ExpenseRepo repo) {
        this.repo = repo;
    }

    public double calculateExpense(){
    List<Transactions> transactions = repo.findByTransactionType(TransactionType.EXPENSE);
        double finalExpense = transactions.stream()
                .mapToDouble(Transactions::getAmount).sum();

        return finalExpense;
    }


}
