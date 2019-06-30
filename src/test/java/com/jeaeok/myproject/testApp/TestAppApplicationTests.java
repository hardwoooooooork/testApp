package com.jeaeok.myproject.testApp;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jeaeok.myproject.testApp.models.User;
import com.jeaeok.myproject.testApp.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAppApplicationTests {
	
	private static final Logger log = LoggerFactory.getLogger(TestAppApplicationTests.class);
	
	final static String CLIENT_ID = "test1";
	final static String CLIENT_SECRET = "test111";

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;


	@Before
	public void deleteAllBeforeTests() throws Exception {
		userRepository.deleteAll();
	}
	
	@Autowired private WebApplicationContext wac;
    private MockMvc mvc;
   
    @Before
    public void setup() {
         mvc = MockMvcBuilders
                   .webAppContextSetup(wac)
                   .apply(SecurityMockMvcConfigurers.springSecurity())
                   .build();
    }
	
    @Test
	public void addUsers() throws Exception {
    	log.info("Start addUsers test");
		userRepository.save(new User(CLIENT_ID, "테스트1", passwordEncoder.encode(CLIENT_SECRET)));
	}
    
    
	
	@Test
    public void loginTest() throws Exception {
    	log.info("Start loginTest test");
    	userRepository.save(new User(CLIENT_ID, "테스트1", passwordEncoder.encode(CLIENT_SECRET)));
    	userRepository.findAll().forEach(user-> log.info("user {} {} {}",user.getUserId(),user.getUserName(),user.getUserPassword()));

        mvc.perform(get("/api/v1/user/info")
        		.with(httpBasic(CLIENT_ID, CLIENT_SECRET)) 
        		.contentType(MediaType.APPLICATION_JSON_UTF8))
        		.andExpect(status().isOk())
                .andDo(print());
        		

	}
	
	@Test
	public void joinUsers() throws Exception {
    	log.info("Start joinUsers test");
    	mvc.perform(
    			post("/api/v1/user/join")
    			.param("userId", "test6")
    			.param("userName", "테스트조인")
    			.param("userPassword", "1234")
        		.contentType(MediaType.APPLICATION_JSON_UTF8))
        		.andExpect(status().isOk())
                .andDo(print());
    	userRepository.findAll().forEach(user-> log.info("user {} {} {}",user.getUserId(),user.getUserName(),user.getUserPassword()));
	}

	@Test
    public void apiCallTest() throws Exception {
    	log.info("Start apiCallTest test");
    	userRepository.save(new User(CLIENT_ID, "테스트1", passwordEncoder.encode(CLIENT_SECRET)));
    	userRepository.findAll().forEach(user-> log.info("user {} {} {}",user.getUserId(),user.getUserName(),user.getUserPassword()));

        mvc.perform(get("/api/v1/local/search/keyword?query=카카오&category_group_code=SW8")
        		.with(httpBasic(CLIENT_ID, CLIENT_SECRET)) 
        		.contentType(MediaType.APPLICATION_JSON_UTF8))
        		.andExpect(status().isOk())
                .andDo(print());
	}

}
