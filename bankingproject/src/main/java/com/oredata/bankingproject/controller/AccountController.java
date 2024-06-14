package com.oredata.bankingproject.controller;

import com.oredata.bankingproject.dto.account.AccountDTO;
import com.oredata.bankingproject.dto.account.AccountSaveRequest;
import com.oredata.bankingproject.dto.account.AccountSearchFormDTO;
import com.oredata.bankingproject.dto.account.AccountUpdateRequest;
import com.oredata.bankingproject.dto.common.ResultDto;
import com.oredata.bankingproject.service.AccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/accounts")
@RestController
@Validated
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/search")
    public ResponseEntity<ResultDto<AccountDTO>> search(@Valid @RequestBody AccountSearchFormDTO searchFormDTO){
        return ResponseEntity.ok(accountService.search(searchFormDTO));
    }
    @PostMapping("/save")
    public ResponseEntity<ResultDto<AccountDTO>> save(@Valid @RequestBody AccountSaveRequest saveRequest){
        return ResponseEntity.ok(accountService.save(saveRequest));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResultDto<AccountDTO>> update(@Valid @PathVariable UUID id, @Valid @RequestBody AccountUpdateRequest updateRequest){
        return ResponseEntity.ok(accountService.update(id,updateRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultDto<AccountDTO>> details(@PathVariable @NotNull UUID id){
        return ResponseEntity.ok(accountService.details(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable @NotNull @Positive UUID id){
        return ResponseEntity.ok(accountService.delete(id));
    }
}
