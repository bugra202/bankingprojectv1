package com.oredata.bankingproject.service;

import com.oredata.bankingproject.dto.account.AccountDTO;
import com.oredata.bankingproject.dto.account.AccountSaveRequest;
import com.oredata.bankingproject.dto.account.AccountSearchFormDTO;
import com.oredata.bankingproject.dto.account.AccountUpdateRequest;
import com.oredata.bankingproject.dto.common.ResultDto;
import com.oredata.bankingproject.entity.Account;

import java.math.BigDecimal;
import java.util.UUID;

public interface AccountService {
    ResultDto<AccountDTO> save(AccountSaveRequest request);
    ResultDto<AccountDTO> update(UUID id, AccountUpdateRequest request);
    Object delete(UUID id);
    ResultDto<AccountDTO> search(AccountSearchFormDTO searchFormDTO);
    ResultDto<AccountDTO> details(UUID id);
    void updateBalance(Account from, Account to, BigDecimal balance);

}
