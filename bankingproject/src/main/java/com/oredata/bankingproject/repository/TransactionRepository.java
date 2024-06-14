package com.oredata.bankingproject.repository;

import com.oredata.bankingproject.dto.transaction.TransactionHistoryResultDb;
import com.oredata.bankingproject.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = """
            select t.id as id, t.from_id::text as fromId ,t.to_id::text as toId ,t.transaction_date as transactionDate,t.status as status,t.amount as amount  from transaction t 
            inner join account a on a.id = t.from_id
            inner join account ac on ac.id = t.to_id
            where a.id = :accountId or ac.id = :accountId
            """, nativeQuery = true)
    List<TransactionHistoryResultDb> transactionHistory(UUID accountId);
}
