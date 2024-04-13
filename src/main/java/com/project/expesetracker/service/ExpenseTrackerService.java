package com.project.expesetracker.service;

import com.project.expesetracker.config.DatabaseSequence;
import com.project.expesetracker.model.Transactions;
import com.project.expesetracker.repository.TransactionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class ExpenseTrackerService {

    @Autowired
    private TransactionsRepo transactionsRepo;

    @Autowired
    private MongoOperations mongoOperations;

    public List<Transactions> getAllExpenses() {
        List<Transactions> result = transactionsRepo.findAll();
        return result;
    }

    public void saveTransaction(Transactions transactions) {
        transactions.setId(generateSequence(Transactions.SEQUENCE_NAME));
        transactionsRepo.save(transactions);
    }

    public long generateSequence(String seqName) {
        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}
