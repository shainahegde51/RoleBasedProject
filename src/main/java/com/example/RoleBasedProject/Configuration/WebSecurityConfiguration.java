package com.example.RoleBasedProject.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        //We will be getting the data from the database so here we are using DaoAuthenticationProvider
        // where Dao stands for Data Access Object

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        //for this Dao we are supposed to provide userDetailsService,
        // userDetailsService is a default spring security interface which helps us to do the authentication it self

        provider.setUserDetailsService(userDetailsService);
        //I have used BCryptPasswordEncoder  to encrypt the password
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return  provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
        http.authorizeRequests()
                .antMatchers( "/addUser").hasAnyAuthority("user","admin")
                .antMatchers("/")
                .permitAll()
                .antMatchers("/user")
                .hasAuthority("user")  // /user is only accessible by user
                .antMatchers("/admin")
                .hasAuthority("admin")// /admin is only accessible by admin
                .anyRequest()
                .authenticated() //any request that comes to /user and /admin has to be authenticated
                .and()
                .httpBasic();
        return http.build();
    }

}
