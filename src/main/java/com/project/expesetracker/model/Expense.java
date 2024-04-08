package com.project.expesetracker.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "Expense")
public class Expense {

    @Id
    private int expenseId;
    private String category;
    private String expenseName;
    private double amount;
    private String expenseDate;
    @Field("IncomeExpenses")
    private List<IncomeExpense> incomeExpenses;
}
