package com.oredata.bankingproject.dto.account;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;
@Builder
public record AccountDTO(UUID id, String number, String name, BigDecimal balance) {}
