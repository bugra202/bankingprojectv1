package com.oredata.bankingproject.mapper;

import com.oredata.bankingproject.dto.transaction.TransactionDTO;
import com.oredata.bankingproject.dto.transaction.TransactionHistoryDTO;
import com.oredata.bankingproject.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);
    TransactionDTO entityToDto(Transaction transaction);

    TransactionHistoryDTO entityToHistoryDTO(Transaction transaction);
}
