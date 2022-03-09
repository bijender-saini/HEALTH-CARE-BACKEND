package com.lattice.exception;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.lattice.util.ResponseHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		logger.info("Exception of MethodArgumentNotValidException {} {} ", ex, ex.getBindingResult());
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		Optional<FieldError> message = fieldErrors.stream().findFirst();
		return message
				.map(fieldError -> ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false,
						fieldError.getDefaultMessage()))
				.orElseGet(() -> ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, null));
	}

	@ExceptionHandler(DataNotFoundException.class)
	ResponseEntity<Object> dataNotFound(Exception ex) {

		return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, ex.getMessage());

	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleException(final Exception e, final WebRequest request) {
		logger.error("Exception: {}", e);
		return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, e.getMessage());
	}

	@ExceptionHandler(BindException.class)
	public ResponseEntity<Object> handleBindException(BindException ex) {
		logger.info("Exception of MethodArgumentNotValidException {} {} ", ex, ex.getBindingResult());
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		Optional<FieldError> message = fieldErrors.stream().findFirst();
		if (message.isPresent()) {
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, message.get().getDefaultMessage());
		} else {
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, null);
		}
	}
}
