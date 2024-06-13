package com.oredata.bankingproject.enums;

public enum TransactionStatus {
    FAILED(0),
    SUCCESS(1);

    private final int value;

    TransactionStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
