package com.oredata.bankingproject.dto.transaction;

import com.oredata.bankingproject.entity.Account;
import com.oredata.bankingproject.enums.TransactionStatus;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record TransactionDTO(Long id,
                             Account from,
                             Account to,
                             BigDecimal amount,
                             LocalDateTime transactionDate,
                             TransactionStatus status
                             ) {
}
