package com.oredata.bankingproject.common.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@Log4j2
public class HealthController {

    @GetMapping
    public ResponseEntity health() {
        try {
            return new ResponseEntity("Healthy", HttpStatus.OK);
        } catch (Throwable t) {
            log.error(t);
            return (ResponseEntity) ResponseEntity.of(ProblemDetail.forStatus(HttpStatus.BAD_REQUEST));
        }
    }

}