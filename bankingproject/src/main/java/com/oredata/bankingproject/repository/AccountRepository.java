package com.oredata.bankingproject.repository;

import com.oredata.bankingproject.dto.account.AccountResultDb;
import com.oredata.bankingproject.dto.account.AccountSearchFormDTO;
import com.oredata.bankingproject.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account,UUID> {
    String ACCOUNT_GRID_QUERY = """
            select a.id::text as id, a.number as number, a.name as name, a.balance as balance
            from account a
            where
            (:#{#searchFormDto.number} is null or a.number LIKE concat('%', :#{#searchFormDto.number}, '%'))
            and (:#{#searchFormDto.name} is null or a.name LIKE concat('%', :#{#searchFormDto.name}, '%'))
            """;
    @Query(value = ACCOUNT_GRID_QUERY, nativeQuery = true)
    List<AccountResultDb> accountDataGridWithFilter(AccountSearchFormDTO searchFormDto);
}
