package com.oredata.bankingproject.service.impl;

import com.oredata.bankingproject.dto.account.AccountSaveDTO;
import com.oredata.bankingproject.dto.account.AccountSaveRequest;
import com.oredata.bankingproject.dto.common.ResultDto;
import com.oredata.bankingproject.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class AccountServiceImpl implements AccountService{
    @Override
    public ResultDto<AccountSaveDTO> save(AccountSaveRequest request) {

            Account account = new Account();


        }
        return null;
    }
}
