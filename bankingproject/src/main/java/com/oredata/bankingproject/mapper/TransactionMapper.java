package com.oredata.bankingproject.mapper;

import com.oredata.bankingproject.dto.transaction.TransactionDTO;
import com.oredata.bankingproject.dto.transaction.TransactionHistoryDTO;
import com.oredata.bankingproject.dto.transaction.TransactionHistoryResultDb;
import com.oredata.bankingproject.entity.Transaction;
import com.oredata.bankingproject.enums.TransactionStatus;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);
    TransactionDTO entityToDto(Transaction transaction);

    @Named("mapToEnum")
    default TransactionStatus map(Integer value) {
        return value == null ? null : TransactionStatus.fromValue(value);
    }

    @Named("mapToInteger")
    default Integer map(TransactionStatus status) {
        return status == null ? null : status.getValue();
    }

    @Mapping(target = "fromId", expression = "java(java.util.UUID.fromString(transactionHistoryResultDb.getFromId()))")
    @Mapping(target = "toId", expression = "java(java.util.UUID.fromString(transactionHistoryResultDb.getToId()))")
    @Mapping(target = "status", source = "status", qualifiedByName = "mapToEnum")
    TransactionHistoryDTO dbResultToDTO(TransactionHistoryResultDb transactionHistoryResultDb);
    List<TransactionHistoryDTO> dbResultToHistoryDTO(List<TransactionHistoryResultDb> transaction);
}
