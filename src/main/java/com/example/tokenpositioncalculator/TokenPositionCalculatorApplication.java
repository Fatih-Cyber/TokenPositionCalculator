package com.example.tokenpositioncalculator;

import com.example.tokenpositioncalculator.service.PositionBuiderService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TokenPositionCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TokenPositionCalculatorApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){ return new ModelMapper();};

}
