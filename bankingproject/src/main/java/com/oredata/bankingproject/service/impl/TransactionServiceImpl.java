package com.oredata.bankingproject.service.impl;

import com.oredata.bankingproject.common.errormessage.GeneralErrorMessage;
import com.oredata.bankingproject.common.exceptions.ItemNotFoundException;
import com.oredata.bankingproject.common.util.ConvertUtils;
import com.oredata.bankingproject.dto.common.ResultDto;
import com.oredata.bankingproject.dto.transaction.TransactionDTO;
import com.oredata.bankingproject.dto.transaction.TransactionHistoryDTO;
import com.oredata.bankingproject.dto.transaction.TransactionMoneyTransferReq;
import com.oredata.bankingproject.entity.Account;
import com.oredata.bankingproject.entity.Transaction;
import com.oredata.bankingproject.enums.TransactionStatus;
import com.oredata.bankingproject.mapper.TransactionMapper;
import com.oredata.bankingproject.repository.AccountRepository;
import com.oredata.bankingproject.repository.TransactionRepository;
import com.oredata.bankingproject.service.AccountService;
import com.oredata.bankingproject.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final AccountService accountService;
    @Override
    public ResultDto<TransactionDTO> transferBalance(TransactionMoneyTransferReq transferReq) {
        // Buralara kendi exceptionlarını yaz
        Account from = accountRepository.findById(transferReq.fromId()).orElseThrow(() -> new ItemNotFoundException(GeneralErrorMessage.ITEM_NOT_FOUND));

        // Buralara kendi exceptionlarını yaz
        Account to = accountRepository.findById(transferReq.toId()).orElseThrow(() -> new ItemNotFoundException(GeneralErrorMessage.ITEM_NOT_FOUND));

        if (from.getBalance().compareTo(transferReq.amount()) < 0) {
            // Buralara kendi exceptionlarını yaz
            throw new IllegalArgumentException("Insufficient funds");
        }

        Transaction transaction = new Transaction();
        transaction.setFrom(from);
        transaction.setTo(to);
        transaction.setAmount(transferReq.amount());
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setStatus(TransactionStatus.SUCCESS);

        transaction = transactionRepository.save(transaction);

        accountService.updateBalance(from,to,transferReq.amount());

        var transactionDTO = TransactionMapper.INSTANCE.entityToDto(transaction);

        return ConvertUtils.listToResponseDtoFunction.apply(Collections.singletonList(transactionDTO));
    }

    @Override
    public ResultDto<TransactionHistoryDTO> transactionHistory(Long accountId) {

        var transactionList = transactionRepository.transactionHistory(accountId);

        List<TransactionHistoryDTO> transactionDTOs = transactionList.stream()
                .map(TransactionMapper.INSTANCE::entityToHistoryDTO)
                .sorted((t1, t2) -> t2.transactionDate().compareTo(t1.transactionDate()))
                .collect(Collectors.toList());

        return ConvertUtils.listToResponseDtoFunction.apply(transactionDTOs);

    }
}
