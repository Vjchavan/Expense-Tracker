package com.project.expesetracker.repository;

import com.project.expesetracker.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepo extends MongoRepository<Expense,Integer> {
}
