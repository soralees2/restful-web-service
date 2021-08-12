package com.springboot.restful.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// HTTP Status code
// 2XX -> OK
// 4XX -> Client
// 5XX -> Server

// 500번대가 아닌 400번대로 에러를 내고 클라이언트에 데이터가 존재하지 않는다는식의 에러메세지를 보여준다
@ResponseStatus(HttpStatus.NOT_FOUND) 
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super(message);
		System.out.println("=====================메세지");
	} 
}
