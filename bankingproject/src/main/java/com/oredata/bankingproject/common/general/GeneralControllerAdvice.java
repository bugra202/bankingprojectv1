package com.oredata.bankingproject.common.general;

import com.oredata.bankingproject.common.exceptions.ItemNotFoundException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
@ControllerAdvice
@RequiredArgsConstructor
public class GeneralControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request) {

        String message = e.getMessage();
        String description = request.getDescription(false);

        var generalErrorMessages = new GeneralErrorMessages(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(generalErrorMessages);

        return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler
    public final ResponseEntity<Object> handleRTExceptions(ItemNotFoundException e, WebRequest request) {

        String message = e.getBaseErrorMessage().getMessage();
        String description = request.getDescription(false);

        var generalErrorMessages = new GeneralErrorMessages(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(generalErrorMessages);

        return new ResponseEntity<>(restResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public final ResponseEntity<Object> handleRTExceptions(BusinessException e, WebRequest request) {

        String message = e.getBaseErrorMessage().getMessage();
        String description = request.getDescription(false);

        var generalErrorMessages = new GeneralErrorMessages(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(generalErrorMessages);

        return new ResponseEntity<>(restResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(TransactionSystemException e, WebRequest request) {

        String message = e.getOriginalException().getCause().getMessage();
        String description = request.getDescription(false);

        var generalErrorMessages = new GeneralErrorMessages(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(generalErrorMessages);

        return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({BadCredentialsException.class, AuthenticationException.class,AccountStatusException.class,
            AccessDeniedException.class,ExpiredJwtException.class, SignatureException.class})
    public ResponseEntity<Object> handleAuthenticationExceptions(Exception exception, WebRequest request) {
        String message = exception.getMessage();
        String description = request.getDescription(false);

        GeneralErrorMessages generalErrorMessages = new GeneralErrorMessages(LocalDateTime.now(), message, description);
        RestResponse<Object> restResponse = RestResponse.error(generalErrorMessages);

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(restResponse);
    }

}
