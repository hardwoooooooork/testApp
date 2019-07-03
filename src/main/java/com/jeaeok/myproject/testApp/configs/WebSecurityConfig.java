package com.jeaeok.myproject.testApp.configs;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
/**
 * 스프링 시큐리티 설정
 * @author atcis
 *
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private AuthProvider authProvider;
	
	
	@Bean
	public PasswordEncoder getEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	
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
//        .ignoringAntMatchers("/h2-console/**")
        .disable()
        .authorizeRequests()
        .antMatchers(
        		"/",
//                "/h2-console/**",
                "/api/v1/user/join",
                "/static/**"
        ).permitAll()
        .anyRequest().authenticated()
        .and()
        .headers().frameOptions().sameOrigin()
        .and()
        .httpBasic()
        .authenticationEntryPoint(new NoPopupBasicAuthenticationEntryPoint())
        ;
		
		http.authenticationProvider(authProvider);
  	}
//	@Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("{noop}password").roles("USER");
//    }

}
