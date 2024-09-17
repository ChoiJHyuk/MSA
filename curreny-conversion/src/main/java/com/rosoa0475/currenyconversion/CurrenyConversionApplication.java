package com.rosoa0475.currenyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // @FeignClient 활성화, 프록시 생성 가능하도록 설정
public class CurrenyConversionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrenyConversionApplication.class, args);
    }

}
