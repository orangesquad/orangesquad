package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long>{
	Users findByMobileAndPassword(String mobile, String password);	
}
