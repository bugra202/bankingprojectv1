package com.oredata.bankingproject.dto.account;

import java.math.BigDecimal;
import java.util.UUID;

public interface AccountResultDb {
    String getId();
    String getNumber();
    String getName();
    BigDecimal getBalance();
}
