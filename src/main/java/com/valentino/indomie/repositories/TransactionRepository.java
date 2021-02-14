package com.valentino.indomie.repositories;

import com.valentino.indomie.entitys.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query(value="select * from transaction  where id like %:keyword%", nativeQuery = true)
    Page<Transaction> findAllById(String keyword, Pageable pageable);
    @Query(value = "select * from transaction where trxDate=:date", nativeQuery = true)
    Page<Transaction> findAllByTrxDate(Date date, Pageable pageable);
}
