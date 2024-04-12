package com.project.expesetracker.model;

import com.project.expesetracker.enums.TransactionType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@Document(collection = "Transactions")
public class Transactions {
    @Id
    private int id;
    private String category;
    private String expenseName;
    private double amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expenseDate;
    private TransactionType transactionType;
}
