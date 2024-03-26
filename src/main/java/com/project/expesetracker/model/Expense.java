package com.project.expesetracker.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Expense")
public class Expense {

    private int id;
    private String category;
    private String expenseName;
    private double expenseAmount;
    private Date expenseDate;
}
