package CRUD_PRACTICE.demo.service;

import CRUD_PRACTICE.demo.constructor.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**");

    }

    @Bean
    public UserInfo userInfo(){
        return new UserInfo();
    }

}
