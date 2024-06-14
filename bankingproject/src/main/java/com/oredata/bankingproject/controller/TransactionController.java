package com.oredata.bankingproject.controller;

import com.oredata.bankingproject.dto.common.ResultDto;
import com.oredata.bankingproject.dto.transaction.TransactionDTO;
import com.oredata.bankingproject.dto.transaction.TransactionHistoryDTO;
import com.oredata.bankingproject.dto.transaction.TransactionMoneyTransferReq;
import com.oredata.bankingproject.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/transactions")
@RestController
@Validated
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;
    @PostMapping("/transfer")
    public ResponseEntity<ResultDto<TransactionDTO>> transferBalance(@Valid @RequestBody TransactionMoneyTransferReq moneyTransferReq){
        return ResponseEntity.ok(service.transferBalance(moneyTransferReq));
    }
    @PostMapping("/account/{debugAccountId}")
    public ResponseEntity<ResultDto<TransactionHistoryDTO>> transferBalance(@Valid @PathVariable UUID debugAccountId){
        return ResponseEntity.ok(service.transactionHistory(debugAccountId));
    }

}
