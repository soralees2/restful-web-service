package com.spring.restful.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.restful.user.UserNotFoundException;

@RestController
@ControllerAdvice // 모든 컨드롤러 실행시 무조건 이 컨트롤러가 실행된다.
public class CustomizedResponseEntityHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){ // WebRequest :어디서 예외가 발생 되었는지에대한 정보 
		System.out.println("=====================aop1");
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	// ResponseEntity<Object> : 사용자 객체 한명 추가했을때 반환시켰던 형태 
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request){ // WebRequest :어디서 예외가 발생 되었는지에대한 정보 
		System.out.println("=====================aop2");
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
