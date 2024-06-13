package com.oredata.bankingproject.dto.transaction;

import com.oredata.bankingproject.entity.Account;
import com.oredata.bankingproject.enums.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionHistoryDTO(Long id,
                                    Account from,
                                    Account to,
                                    BigDecimal amount,
                                    LocalDateTime transactionDate,
                                    TransactionStatus status) {
}
