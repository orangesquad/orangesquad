package com.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.test.constant.BasicConstant;
import com.test.dto.ResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseDto> noUserDataAvaliableException() {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(BasicConstant.INVALID_LOGIN);
		responseDto.setStatusCode(BasicConstant.NOTFOUND_CODE);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
	}
}