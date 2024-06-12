package com.oredata.bankingproject.common.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Log4j2
@Aspect
@Component
@RequiredArgsConstructor
public class AspectService {

    private final ObjectMapper objectMapper;

    public void logInfo(JoinPoint joinPoint, Object result) {

    }


}
