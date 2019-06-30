package com.jeaeok.myproject.testApp.configs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jeaeok.myproject.testApp.models.MyAuthenticaion;
import com.jeaeok.myproject.testApp.models.User;
import com.jeaeok.myproject.testApp.services.UserService;

@Component("authProvider")
/**
 * 로그인 확인 하는 클레
 * @author atcis
 *
 */
public class AuthProvider implements AuthenticationProvider  {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@Autowired
    private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String id = authentication.getName();
		String password = authentication.getCredentials().toString();

		User user_info = userService.getUser(id);
		
        if (null == user_info || !passwordEncoder.matches(password, user_info.getUserPassword())) {
            return null;
        }
		
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
		if (user_info.isAdmin()) {
			grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		return new MyAuthenticaion(id, password, grantedAuthorityList, user_info);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}


}
