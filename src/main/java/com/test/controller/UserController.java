package com.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.constant.BasicConstant;
import com.test.dto.LoginDto;
import com.test.dto.LoginResponseDto;
import com.test.exception.UserNotFoundException;
import com.test.service.UserService;

/**
 * 
 * @author 
 * @version 1.0
 * @since 17-02-2020
 */
@RestController
@RequestMapping("/users")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;

	/**
	 * This method is used to validating the user by providing the input as LoginDto
	 * 
	 * @param loginDto
	 * @return responseDTO
	 * @throws UserNotFoundException 
	 */
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> usersLogin(@RequestBody LoginDto loginDto) throws UserNotFoundException{
		LOGGER.info("Inside UserController :: userLogin.");
		LoginResponseDto loginResponseDto = userService.usersLogin(loginDto);
		loginResponseDto.setMessage(BasicConstant.LOGIN_SUCCESS);
		loginResponseDto.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
	}

}
