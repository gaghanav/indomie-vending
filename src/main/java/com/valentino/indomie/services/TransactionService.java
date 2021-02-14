package com.valentino.indomie.services;

import com.valentino.indomie.entitys.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;

public interface TransactionService {
    public Transaction saveTransactions(Transaction transaction);
    public Page<Transaction> getAllTransactions(Pageable pageable);
    public Page<Transaction> getTransactionById(Pageable pageable, String id);
    public Page<Transaction> getTransactionByDate(Pageable pageable, Date date);
}
