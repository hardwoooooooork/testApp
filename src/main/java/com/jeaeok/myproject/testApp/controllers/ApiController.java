package com.jeaeok.myproject.testApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeaeok.myproject.testApp.domain.HotKeyWord;
import com.jeaeok.myproject.testApp.domain.Keyword;
import com.jeaeok.myproject.testApp.domain.User;
import com.jeaeok.myproject.testApp.services.ApiService;
import com.jeaeok.myproject.testApp.services.UserService;

@RestController
@RequestMapping(path = "/api/v1")
public class ApiController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ApiService apiService;
	
	/**
	 * api Key 가져오기
	 * @return
	 */
	@GetMapping(path="/apiKey", produces = "application/json")
	public String getapiKey(){
		return apiService.getApiKey();
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
	
	@GetMapping(path = "/hotkeyword" , produces = "application/json")
	public List<HotKeyWord> getHotKeywordList(){
		return apiService.getHotKeywordList();
	}
	
	@PostMapping(path="/user/join", produces = "application/json")
	public User addUser(User user){
		return userService.addUser(user);
	}
}
