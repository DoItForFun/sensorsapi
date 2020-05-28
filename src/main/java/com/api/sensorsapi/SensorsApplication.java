package com.api.sensorsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SensorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SensorsApplication.class, args);
    }

}
