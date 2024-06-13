package com.oredata.bankingproject.repository;

import com.oredata.bankingproject.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = """
            select t from transaction t 
            inner join account a on a.id = t.from_id
            inner join account ac on ac.id = t.to_id
            where a.number = :accountNumber or ac.number = :accountNumber
            """, nativeQuery = true)
    List<Transaction> transactionHistory(String accountNumber);
}
