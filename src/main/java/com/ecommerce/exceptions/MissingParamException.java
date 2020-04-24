package com.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Missing required parameters")
public final class MissingParamException extends RuntimeException {

    /**
     * Unique ID for Serialized object
     */
    private static final long serialVersionUID = -8790211652911971729L;
    
    public MissingParamException(String paramType) {
		super(paramType + "required. Please resend with required parameters");
	}

}