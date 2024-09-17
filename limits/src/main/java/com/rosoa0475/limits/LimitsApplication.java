package com.rosoa0475.limits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class LimitsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LimitsApplication.class, args);
    }

}
