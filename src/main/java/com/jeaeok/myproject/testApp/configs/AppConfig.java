package com.jeaeok.myproject.testApp.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jeaeok.myproject.testApp.domain.User;
import com.jeaeok.myproject.testApp.repositories.UserRepository;

@Configuration
/**
 * webapplication 기본설정
 * @author atcis
 *
 */
public class AppConfig {
	private static final Logger log = LoggerFactory.getLogger(AppConfig.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Bean
	/**
	 * 패스워드 암호화설정
	 * @return
	 */
	public PasswordEncoder getEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	/**
	 * 시작시 먼저 동작되는 메서드
	 * @param userRepository
	 * @return
	 */
	public CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args -> {
			log.info("Create Test Id : {} pw : {}" , "test1", "1234");
			 userRepository.save(new User("test1","테스트1",passwordEncoder.encode("1234")));
		};
	}
	
}
