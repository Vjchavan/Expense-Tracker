package com.project.expesetracker.repository;

import com.project.expesetracker.enums.TransactionType;
import com.project.expesetracker.model.Transactions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepo extends MongoRepository<Transactions,Integer> {
    List<Transactions> findByTransactionType(TransactionType expense);
}
