package com.oredata.bankingproject.dto.transaction;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionMoneyTransferReq(@NotNull
                                          UUID fromId,
                                          @NotNull
                                          UUID toId,
                                          @NotNull
                                          @Positive
                                          BigDecimal amount) {
}
