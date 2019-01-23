package com.cg.jcat.api.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.HttpStatus;

import com.cg.jcat.api.exception.DeleteUserException;
import com.cg.jcat.api.exception.SaveUserException;
import com.cg.jcat.api.exception.SystemExceptions;
import com.cg.jcat.api.exception.UserAlreadyExistsException;
import com.cg.jcat.api.exception.entity.ErrorDTO;

@ControllerAdvice
public class UserExceptionHandler {
//UserAlreadyExistsExceptionHandler
	
	@ExceptionHandler(value = UserAlreadyExistsException.class)
	public ResponseEntity<Object> UserExistsException(UserAlreadyExistsException exception,WebRequest request) {

		ErrorDTO errorDetails = new ErrorDTO(exception.getErrorDTO().getError_code(),
				exception.getErrorDTO().getError_message(), exception.getErrorDTO().getError_value(),exception.getErrorDTO().getError_timestamp(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = SaveUserException.class)
	public ResponseEntity<Object> UserSaveException(SaveUserException exception,WebRequest request) {

		ErrorDTO errorDetails = new ErrorDTO(exception.getErrorDTO().getError_code(),
				exception.getErrorDTO().getError_message(), exception.getErrorDTO().getError_value(),exception.getErrorDTO().getError_timestamp(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(value = DeleteUserException.class)
	public ResponseEntity<Object> DeleteException(DeleteUserException exception,WebRequest request) {

		ErrorDTO errorDetails = new ErrorDTO(exception.getErrorDTO().getError_code(),
				exception.getErrorDTO().getError_message(), exception.getErrorDTO().getError_value(),exception.getErrorDTO().getError_timestamp(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(value = SystemExceptions.class)
	public ResponseEntity<Object> SystemException(SystemExceptions exception,WebRequest request) {

		ErrorDTO errorDetails = new ErrorDTO(exception.getErrorDTO().getError_code(),
				exception.getErrorDTO().getError_message(), exception.getErrorDTO().getError_value(),exception.getErrorDTO().getError_timestamp(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);
	}

}
