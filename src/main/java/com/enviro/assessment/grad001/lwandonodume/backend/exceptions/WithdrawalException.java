package com.enviro.assessment.grad001.lwandonodume.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WithdrawalException extends Exception {
    public WithdrawalException(String message) {
        super(message);
    }
}

