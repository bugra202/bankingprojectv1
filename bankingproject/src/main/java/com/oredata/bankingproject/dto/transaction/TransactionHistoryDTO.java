package com.oredata.bankingproject.dto.transaction;

import com.oredata.bankingproject.enums.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


public record TransactionHistoryDTO(Long id,
                                    UUID fromId,
                                    UUID toId,
                                    BigDecimal amount,
                                    LocalDateTime transactionDate,
                                    TransactionStatus status) {
}
