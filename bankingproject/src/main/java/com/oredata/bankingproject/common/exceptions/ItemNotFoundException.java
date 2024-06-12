package com.oredata.bankingproject.common.exceptions;

import com.oredata.bankingproject.common.errormessage.BaseErrorMessage;
import com.oredata.bankingproject.common.general.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends BusinessException {
    public ItemNotFoundException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
