package com.Step07.springboot.myFirstApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
        UserDetails usersDetails3 = createNewUser("rayen","123");
        UserDetails usersDetails1 = createNewUser("ibrahiim","456");
        return new InMemoryUserDetailsManager(usersDetails1, usersDetails3);
    }

    private UserDetails createNewUser(String username, String password) {
        UserDetails usersDetails = User.builder()
                .password(password)
                .passwordEncoder(passwordEncoder)
                .username(username)
                .roles("USER", "ADMIN")
                .build();
        return usersDetails;
    }

    @Bean
    public PasswordEncoder  passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
        http.formLogin(withDefaults());

        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }
}
