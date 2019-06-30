package com.jeaeok.myproject.testApp.configs;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
/**
 * 로그인한 사용자의 정보를 확인하는 클레
 * @author atcis
 *
 */
public class AuthenticationFacade {
	public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
