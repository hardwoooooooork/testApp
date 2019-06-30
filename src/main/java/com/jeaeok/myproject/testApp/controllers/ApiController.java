package com.jeaeok.myproject.testApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeaeok.myproject.testApp.models.Keyword;
import com.jeaeok.myproject.testApp.models.User;
import com.jeaeok.myproject.testApp.services.ApiService;
import com.jeaeok.myproject.testApp.services.UserService;

@RestController
@RequestMapping(path = "/api/v1")
public class ApiController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ApiService apiService;
	
	
	@PostMapping(path="/user/join", produces = "application/json")
	public User addUser(User user){
		return userService.addUser(user);
	}
	
	/**
	 * 로그인정보 확인 컨트롤러
	 * @return
	 */
	@GetMapping(path="/user/info", produces = "application/json")
	public User getUsers(){
		return userService.userInfo();
	}
	
	/**
	 * 카카오 키워드 컨트롤러
	 * @param keyword
	 * @return
	 */
	@GetMapping(path = "/local/search/keyword" , produces = "application/json")
	public String searchKeyword(Keyword keyword) {
		return apiService.searchKeyword(keyword);
	}
	
	@GetMapping(path = "/user/info/keyword" , produces = "application/json")
	public List<Keyword> getMySearchList(){
		return userService.getMySearchList();
	}
}
