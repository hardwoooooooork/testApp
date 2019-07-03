package com.jeaeok.myproject.testApp.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.jeaeok.myproject.testApp.domain.User;
import com.jeaeok.myproject.testApp.repositories.UserRepository;

@Component
public class ApplicationStartUpListener {
	static final Logger log = LoggerFactory.getLogger(ApplicationStartUpListener.class);

	
	@Autowired
	private UserRepository userRepository;
	
	
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		
		BCryptPasswordEncoder bCryp = new BCryptPasswordEncoder();
		
		log.info("Create Test Id : {} pw : {}" , "test1", "1234");
		 userRepository.save(new User("test1","테스트1",bCryp.encode("1234")));
		 log.info("Create Test Id : {} pw : {}" , "test2", "1234");
		 userRepository.save(new User("test2","테스트2",bCryp.encode("1234")));
		 log.info("Create Test Id : {} pw : {}" , "test3", "1234");
		 userRepository.save(new User("test3","테스트3",bCryp.encode("1234")));
	}
}
