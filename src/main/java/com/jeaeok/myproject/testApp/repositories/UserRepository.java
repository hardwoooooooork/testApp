package com.jeaeok.myproject.testApp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jeaeok.myproject.testApp.models.User;


public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	List<User> findByUserId(String userId);
}
