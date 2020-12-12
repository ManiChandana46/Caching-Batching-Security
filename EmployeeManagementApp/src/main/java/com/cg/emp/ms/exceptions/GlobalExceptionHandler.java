package com.cg.emp.ms.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	// to handle the specific exception
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> handleEmployeeNotFoundException(EmployeeNotFoundException exp, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(new Date(), exp.getMessage(), req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	
	
	
	
	/*
	 * // for invalid URl
	 * 
	 * @ExceptionHandler(NoHandlerFoundException.class) public ResponseEntity<?>
	 * handleGlobalException2(NoHandlerFoundException exp,WebRequest req){
	 * 
	 * MyErrorDetails err=new MyErrorDetails(new Date(), exp.getMessage(),
	 * req.getDescription(false));
	 * 
	 * return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR); }
	 */
	 
	
	
	  //to handle the all other exceptions
	  
	  @ExceptionHandler(Exception.class)
	  public ResponseEntity<?> handleGlobalException(Exception exp,WebRequest req){
	  
	  MyErrorDetails err=new MyErrorDetails(new Date(), exp.getMessage(),
	  req.getDescription(false));
	  
	  return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR); }
	 

	
	  // For Validation Error
	  
	
	  @ExceptionHandler(MethodArgumentNotValidException.class) public
	  ResponseEntity<?>
	  handleMethodArgumentNotValidException(MethodArgumentNotValidException exp) {
	  
	  MyErrorDetails err = new MyErrorDetails(new Date(), "Validation Error",
	  exp.getBindingResult().getFieldError().getDefaultMessage());
	  
	  return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST); }
	 
	 
}
