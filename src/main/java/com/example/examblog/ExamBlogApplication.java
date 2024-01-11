package com.example.examblog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamBlogApplication.class, args);
    }


    @Bean
    CommandLineRunner coucou(){
        return args -> {
            System.out.println("GOOD");
        };
    }
}
