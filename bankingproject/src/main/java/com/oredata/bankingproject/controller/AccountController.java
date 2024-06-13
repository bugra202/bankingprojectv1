package com.oredata.bankingproject.controller;

import com.oredata.bankingproject.dto.account.AccountSaveDTO;
import com.oredata.bankingproject.dto.account.AccountSaveRequest;
import com.oredata.bankingproject.dto.common.ResultDto;
import com.oredata.bankingproject.service.impl.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/accounts")
@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/save")
    public ResponseEntity<ResultDto<AccountSaveDTO>> save(@RequestBody AccountSaveRequest saveRequest){
        return ResponseEntity.ok(accountService.save(saveRequest));
    }
}
