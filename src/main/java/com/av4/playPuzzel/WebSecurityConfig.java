package com.av4.playPuzzel;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	/*
    	 * This will allow all the request from any origin 
    	 * */
    	
        http.cors().and().csrf().disable();
//            .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//            .httpBasic();
    }
}
