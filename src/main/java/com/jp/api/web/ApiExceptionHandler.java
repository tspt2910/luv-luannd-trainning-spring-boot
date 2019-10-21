package com.jp.api.web;

import jp.xet.sparwings.spring.web.httpexceptions.HttpBadRequestException;
import jp.xet.sparwings.spring.web.httpexceptions.HttpConflictException;
import jp.xet.sparwings.spring.web.httpexceptions.HttpNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller advice api.
 *
 */
@RestControllerAdvice
public class ApiExceptionHandler {
	
	/**
	 * Handle catch MethodArgumentNotValidException.
	 *
	 * @param exception MethodArgumentNotValidException
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity handleMANVException(MethodArgumentNotValidException exception) {
		//Get all errors
		List<String> errors = exception.getBindingResult()
			.getFieldErrors()
			.stream()
			.map(x -> x.getDefaultMessage())
			.collect(Collectors.toList());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle catch IllegalArgumentException.
	 *
	 * @param exception IllegalArgumentException
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity handleMANVException(IllegalArgumentException exception) {
		HttpExceptionResponse response = new HttpExceptionResponse("bad_request", exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}


	
	/**
	 * Handle catch HttpBadRequestException.
	 *
	 * @param exception HttpBadRequestException
	 */
	@ExceptionHandler(HttpBadRequestException.class)
	public ResponseEntity handleHBRException(HttpBadRequestException exception) {
		
		HttpExceptionResponse response = new HttpExceptionResponse("bad_request", exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Handle catch HttpNotFoundException.
	 *
	 * @param exception HttpNotFoundException
	 */
	@ExceptionHandler(HttpNotFoundException.class)
	public ResponseEntity handleHNFException(HttpNotFoundException exception) {
		HttpExceptionResponse response = new HttpExceptionResponse("not_found", exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Handle catch HttpConflictException.
	 *
	 * @param exception HttpConflictException
	 */
	@ExceptionHandler(HttpConflictException.class)
	public ResponseEntity handleHCException(HttpConflictException exception) {
		
		HttpExceptionResponse response = new HttpExceptionResponse("conflict", exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}
	
	/**
	 * Handle catch NullPointerException.
	 *
	 * @param exception NullPointerException
	 */
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity handleNPException(NullPointerException exception) {
		HttpExceptionResponse response = new HttpExceptionResponse("server_error", exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Handle catch HttpRequestMethodNotSupportedException.
	 *
	 * @param exception HttpRequestMethodNotSupportedException
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity handleHRMNSException(HttpRequestMethodNotSupportedException exception) {
		HttpExceptionResponse response = new HttpExceptionResponse("method_not_allowed", exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
}
