package com.oredata.bankingproject.service.impl;

import com.oredata.bankingproject.dto.account.AccountSaveDTO;
import com.oredata.bankingproject.dto.account.AccountSaveRequest;
import com.oredata.bankingproject.dto.common.ResultDto;

public interface AccountService {
    ResultDto<AccountSaveDTO> save(AccountSaveRequest request);

}
