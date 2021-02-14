package com.valentino.indomie.repositories;

import com.valentino.indomie.entitys.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query(value="select * from transactions t where t.id like %:id%", nativeQuery = true)
    Page<Transaction> findAllById(Pageable pageable, String id);
    @Query(value = "select * from transactions t where t.trxDate=:date", nativeQuery = true)
    Page<Transaction> findAllByTrxDate(Pageable pageable, Date date);
}
