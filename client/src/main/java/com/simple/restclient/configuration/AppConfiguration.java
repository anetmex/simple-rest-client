package com.simple.restclient.configuration;

import com.simple.restclient.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

}
