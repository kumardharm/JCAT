package com.cg.jcat.api.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.cg.jcat.api.exception.SystemExceptions;
import com.cg.jcat.api.exception.entity.ErrorDTO;

@ControllerAdvice
public class ProviderExceptionHandler {
	
	@ExceptionHandler(value = SystemExceptions.class)
	public ResponseEntity<Object> SystemException(SystemExceptions exception,WebRequest request) {

		ErrorDTO errorDetails = new ErrorDTO(exception.getErrorDTO().getError_code(),
				exception.getErrorDTO().getError_message(), exception.getErrorDTO().getError_value(),exception.getErrorDTO().getError_timestamp(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);
	}

}