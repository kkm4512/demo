package CRUD_PRACTICE.demo.service;

import CRUD_PRACTICE.demo.constructor.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public UserInfo userInfo(){
        return new UserInfo();
    }

}
