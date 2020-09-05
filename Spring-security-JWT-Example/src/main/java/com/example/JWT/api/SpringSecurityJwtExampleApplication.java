package com.example.JWT.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.JWT.api.entity.Users;
import com.example.JWT.api.repository.UserRepository;

@SpringBootApplication

public class SpringSecurityJwtExampleApplication {

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
	}
	
	@PostConstruct
	public void initUsers() {
		List<Users> collect = Stream.of(new Users(101,"storm","Storm@gmail.com","99991"),
				new Users(102,"gaming","gaming@gmail.com","88881"),
				new Users(103,"world","world@gmail.com","00001")
				
				).collect(Collectors.toList());
		userRepository.saveAll(collect);
	}
	

    @Bean
    public WebMvcConfigurer corsConfigurer() 
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedHeaders("*").allowedOrigins("*").allowedMethods("*").allowCredentials(true);
            }
        };
    }
	
	
	
}
