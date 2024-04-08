package com.project.expesetracker.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "IncomeExpense")
public class IncomeExpense {
    private int income;
    private int expense;
}
