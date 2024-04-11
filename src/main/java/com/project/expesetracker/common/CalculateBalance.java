package com.project.expesetracker.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculateBalance {

    @Autowired
    private CalculateExpense calculateExpense;
    @Autowired
    private CalculateIncome calculateIncome;

    public double calculateBalance(){
        double balance = calculateIncome.calculateIncome() - calculateExpense.calculateExpense();
        return balance;
    }

}
