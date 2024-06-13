package com.oredata.bankingproject.dto.account;

import lombok.Builder;

import java.util.UUID;
@Builder
public record AccountSaveDTO(UUID id, String number, String name, String balance) {}
