package com.project.expesetracker.model;

import com.project.expesetracker.enums.TransactionType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Transactions")
public class Transactions {
    @Id
    private int id;
    private String category;
    private String expenseName;
    private double amount;
    private String expenseDate;
    private TransactionType transactionType;
}
