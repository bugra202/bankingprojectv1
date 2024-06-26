package com.oredata.bankingproject.common.errormessage;

import lombok.Getter;

@Getter
public enum GeneralErrorMessage implements BaseErrorMessage{
    ITEM_NOT_FOUND("Item not found!");
    private final String message;

    GeneralErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
