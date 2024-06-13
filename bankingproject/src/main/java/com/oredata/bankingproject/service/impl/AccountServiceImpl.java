package com.oredata.bankingproject.service.impl;

import com.oredata.bankingproject.common.errormessage.GeneralErrorMessage;
import com.oredata.bankingproject.common.exceptions.ItemNotFoundException;
import com.oredata.bankingproject.common.util.ConvertUtils;
import com.oredata.bankingproject.dto.account.*;
import com.oredata.bankingproject.dto.common.ResultDto;
import com.oredata.bankingproject.entity.Account;
import com.oredata.bankingproject.mapper.AccountMapper;
import com.oredata.bankingproject.repository.AccountRepository;
import com.oredata.bankingproject.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    @Override
    public ResultDto<AccountDTO> search(AccountSearchFormDTO searchFormDTO) {
        List<AccountResultDb> accountResultDbList = repository.accountDataGridWithFilter(searchFormDTO);
        var accountDTOS = AccountMapper.INSTANCE.dbResultToDTO(accountResultDbList);
        return ConvertUtils.listToResponseDtoFunction.apply(accountDTOS);
    }

    @Override
    public ResultDto<AccountDTO> details(UUID id) {
        var account = repository.findById(id).orElseThrow(() -> new ItemNotFoundException(GeneralErrorMessage.ITEM_NOT_FOUND));
        var accountDTO = AccountMapper.INSTANCE.entityToDTO(account);
        return ConvertUtils.listToResponseDtoFunction.apply(Collections.singletonList(accountDTO));
    }

    @Override
    public void updateBalance(Account from, Account to, BigDecimal balance) {
        from.setBalance(from.getBalance().subtract(balance));
        to.setBalance(to.getBalance().add(balance));

        repository.save(from);
        repository.save(from);
    }

    @Override
    public ResultDto<AccountDTO> save(AccountSaveRequest request) {

        Account account = AccountMapper.INSTANCE.saveRequestToEntity(request);
        account = repository.save(account);

        var accountSaveDTO = AccountMapper.INSTANCE.entityToDTO(account);
        return ConvertUtils.listToResponseDtoFunction.apply(Collections.singletonList(accountSaveDTO));
    }

    @Override
    public ResultDto<AccountDTO> update(UUID id, AccountUpdateRequest request) {

        Account account = repository.findById(id).orElseThrow(() -> new ItemNotFoundException(GeneralErrorMessage.ITEM_NOT_FOUND));
        AccountMapper.INSTANCE.updateRequestToEntity(account,request);
        repository.save(account);
        var accountDTO = AccountMapper.INSTANCE.entityToDTO(account);

        return ConvertUtils.listToResponseDtoFunction.apply(Collections.singletonList(accountDTO));
    }

    @Override
    public Object delete(UUID id) {
        repository.deleteById(id);
        return true;
    }
}
