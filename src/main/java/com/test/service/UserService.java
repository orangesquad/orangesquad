package com.test.service;

import com.test.dto.LoginDto;
import com.test.dto.LoginResponseDto;
import com.test.exception.UserNotFoundException;

public interface UserService {

	LoginResponseDto usersLogin(LoginDto loginDto) throws UserNotFoundException ;
}
