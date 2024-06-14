package com.oredata.bankingproject.enums;

import lombok.Getter;

@Getter
public enum TransactionStatus {
    FAILED(0),
    SUCCESS(1);

    private final int value;

    TransactionStatus(int value) {
        this.value = value;
    }
    public static TransactionStatus fromValue(int value) {
        for (TransactionStatus status : TransactionStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }
}