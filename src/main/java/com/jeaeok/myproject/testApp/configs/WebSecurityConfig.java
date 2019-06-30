package com.jeaeok.myproject.testApp.configs;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
/**
 * 스프링 시큐리티 설정
 * @author atcis
 *
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private AuthProvider authProvider;
	
	
	
	
	@Override
	/**
	 * 스크링 시큐리트를 통하여 접근페이지 설정
	 */
	protected void configure(HttpSecurity http) throws Exception{
		http
		.logout()                                                                
        .logoutUrl("/api/logout")
        .and()
        .csrf()
        .ignoringAntMatchers("/h2-console/**")
        .disable()
        .authorizeRequests()
        .antMatchers(
        		"/",
                "/h2-console/**",
                "/api/v1/user/join"
        ).permitAll()
        .anyRequest().authenticated()
        .and()
        .headers().frameOptions().sameOrigin()
        .and()
        .httpBasic();
		
		http.authenticationProvider(authProvider);
  	}
//	@Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("{noop}password").roles("USER");
//    }

}
