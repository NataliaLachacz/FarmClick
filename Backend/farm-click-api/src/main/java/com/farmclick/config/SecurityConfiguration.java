package com.farmclick.config;

import com.farmclick.security.JwtFilter;
import com.farmclick.security.UserAuthorities;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/user").hasAuthority(UserAuthorities.USER.getAuthorityName())
                .antMatchers(HttpMethod.GET,"/user/stats").hasAuthority(UserAuthorities.USER.getAuthorityName())
                .antMatchers(HttpMethod.DELETE, "/user/{int:id}").hasAuthority(UserAuthorities.ADMIN.getAuthorityName())
                .antMatchers(HttpMethod.GET, "/plant/*").permitAll()
                .antMatchers("/**").denyAll()
                .and()
                .addFilter(new JwtFilter(authenticationManager()))
                .csrf().disable();
    }
}
