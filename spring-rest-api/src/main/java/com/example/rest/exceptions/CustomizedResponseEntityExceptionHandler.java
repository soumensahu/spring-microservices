package com.example.rest.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	@Override
	protected ResponseEntity<Object> handleExceptionInternal
	(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		EceptionResponse exResponse=new EceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(exResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
