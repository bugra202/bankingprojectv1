package com.oredata.bankingproject.service;

import com.oredata.bankingproject.dto.common.ResultDto;
import com.oredata.bankingproject.dto.transaction.TransactionDTO;
import com.oredata.bankingproject.dto.transaction.TransactionHistoryDTO;
import com.oredata.bankingproject.dto.transaction.TransactionMoneyTransferReq;

import java.util.UUID;

public interface TransactionService {
    ResultDto<TransactionDTO> transferBalance(TransactionMoneyTransferReq transferReq);
    ResultDto<TransactionHistoryDTO> transactionHistory(UUID accountId);
}
