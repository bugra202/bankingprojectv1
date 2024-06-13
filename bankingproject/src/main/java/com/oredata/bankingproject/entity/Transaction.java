package com.oredata.bankingproject.entity;

import com.oredata.bankingproject.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "TRANSACTION")
@Entity
public class Transaction extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(
            name = "FROM_ID",
            referencedColumnName = "ID"
    )
    @ManyToOne(fetch = FetchType.LAZY)
    private Account from;

    @JoinColumn(
            name = "TO_ID",
            referencedColumnName = "ID"
    )
    @ManyToOne(fetch = FetchType.LAZY)
    private Account to;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    private LocalDateTime transactionDate;

    private TransactionStatus status;
}
