package com.jeaeok.myproject.testApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jeaeok.myproject.testApp.configs.AuthenticationFacade;
import com.jeaeok.myproject.testApp.domain.HotKeyWord;
import com.jeaeok.myproject.testApp.domain.Keyword;
import com.jeaeok.myproject.testApp.domain.User;
import com.jeaeok.myproject.testApp.repositories.KeywordRepository;
import com.jeaeok.myproject.testApp.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private AuthenticationFacade authenticationFacade;
	
	@Autowired
	private KeywordRepository keywordRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public User userInfo() {
		String userId = authenticationFacade.getAuthentication().getName();
		List<User> users = userRepository.findByUserId(userId);
		if(users.size() == 0 ) return null;
		User user = users.get(0);
		user.setUserPassword(null);
		user.setNum(null);
		return user;
	}
	
	public User getUser(String userId) {
		List<User> users = userRepository.findByUserId(userId);
		return (users.size() > 0) ? users.get(0) : null;
	}

	public List<Keyword> getMySearchList() {
		User user = userInfo();		
		return keywordRepository.findByUserOrderByCreatedTimeAsc(user);
	}

	public User addUser(User user) {
		user.setUserPassword( passwordEncoder.encode(user.getUserPassword()) );
		return userRepository.save(user);
	}

}
