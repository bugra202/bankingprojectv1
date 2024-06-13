package com.oredata.bankingproject.mapper;

import com.oredata.bankingproject.dto.account.AccountDTO;
import com.oredata.bankingproject.dto.account.AccountResultDb;
import com.oredata.bankingproject.dto.account.AccountSaveRequest;
import com.oredata.bankingproject.dto.account.AccountUpdateRequest;
import com.oredata.bankingproject.entity.Account;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    Account saveRequestToEntity(AccountSaveRequest request);
    AccountDTO entityToDTO(Account account);
    @Mapping(target = "id", ignore = true)
    void updateRequestToEntity(@MappingTarget Account account, AccountUpdateRequest request);
    List<AccountDTO> dbResultToDTO(List<AccountResultDb> accountResultDbList);

}


