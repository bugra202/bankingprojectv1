package com.oredata.bankingproject.dto.account;

import jakarta.validation.constraints.*;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record AccountUpdateRequest(
        @NotBlank @Size(min = 2, message = "Must be not null") String number,
        @NotBlank @Size(min = 2, message = "Must be not null") String name,
        @NotNull(message = "Balance must not be null")
        @DecimalMin(value = "0.00", inclusive = true, message = "Balance must be greater than or equal to 0")
        @Digits(integer = 19, fraction = 2, message = "Balance must be a valid monetary amount with up to 19 digits and 2 decimal places") BigDecimal balance) {
}
