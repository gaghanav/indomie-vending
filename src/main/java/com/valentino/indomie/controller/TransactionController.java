package com.valentino.indomie.controller;

import com.valentino.indomie.entitys.Transaction;
import com.valentino.indomie.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping("/transactions")
    public Page<Transaction> getAllTransactions(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        return transactionService.getAllTransactions(PageRequest.of(page, size));
    }
    @GetMapping("/transactions_search")
    public Page<Transaction> getAllTransactionsById(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size, @RequestParam(name = "keyword") String keyword){
        return transactionService.getTransactionById(PageRequest.of(page,size), keyword);
    }
    @PostMapping("/transaction_post")
    public Transaction saveTrx(@RequestBody Transaction transaction){
        return transactionService.saveTransactions(transaction);
    }
}
