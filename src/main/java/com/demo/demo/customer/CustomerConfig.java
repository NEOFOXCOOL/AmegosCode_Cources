package com.demo.demo.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("Welcome to reality noting is like you inspected as well, Chose you destiny if you win to live you life as you dream !!");
        };
    }

}
