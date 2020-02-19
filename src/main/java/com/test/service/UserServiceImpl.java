package com.test.service;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.constant.BasicConstant;
import com.test.dto.LoginDto;
import com.test.dto.LoginResponseDto;
import com.test.entity.Users;
import com.test.exception.UserNotFoundException;
import com.test.repository.UserRepository;

/**
 * @author Shankar
 *
 * method is used to check whether the user is valid or invalid
 * 
 */

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository userRepository;

	/**
	 * @author Shankar
	 *
	 *         Method is used to check whether the user is valid or not
	 *
	 * @param UserDto.
	 * @return LoginResponseDto.
	 * @throws UserNotFoundException 
	 */

	@Override
	public LoginResponseDto usersLogin(LoginDto loginDto) throws UserNotFoundException{
		LOGGER.info("Inside BookingsServiceImpl :: usersLogin.");
		Users users = userRepository.findByMobileAndPassword(loginDto.getMobile(), loginDto.getPassword());
		LoginResponseDto responseDto = new LoginResponseDto();
		if (!Objects.isNull(users)) {			
			responseDto.setUserId(users.getUserId());
			responseDto.setRoleName(users.getRoleName());
			responseDto.setMessage(BasicConstant.SUCCESS);
		} else {
			responseDto.setMessage(BasicConstant.INVALID_USER);
			throw new UserNotFoundException(BasicConstant.CODE,BasicConstant.INVALID_LOGIN);
		}
		return responseDto;
	}

}
