package com.spring.restful.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//예외가 발생했을 시에 사용될 클래스
public class ExceptionResponse {
	
	private Date timestamp; // 예외 발생 시
	private String message; // 예외 발생 메세
	private String details; // 예외 상세 내용
	
}
