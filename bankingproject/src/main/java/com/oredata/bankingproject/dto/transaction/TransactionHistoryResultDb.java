package com.oredata.bankingproject.dto.transaction;

import com.oredata.bankingproject.enums.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface TransactionHistoryResultDb {
    Long getId();
    String getFromId();
    String getToId();
    BigDecimal getAmount();
    LocalDateTime getTransactionDate();
    Integer getStatus();
}
