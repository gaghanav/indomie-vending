package com.valentino.indomie.services.impl;

import com.valentino.indomie.entitys.Transaction;
import com.valentino.indomie.repositories.TransactionRepository;
import com.valentino.indomie.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public Transaction saveTransactions(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Page<Transaction> getAllTransactions(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }

    @Override
    public Page<Transaction> getTransactionById(Pageable pageable, String id) {
        return transactionRepository.findAllById(id, pageable);
    }

    @Override
    public Page<Transaction> getTransactionByDate(Pageable pageable, Date date) {
        return transactionRepository.findAllByTrxDate(date, pageable);
    }
}
