package com.rosoa0475.currenyconversion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange") //spring.application.name과 동일하게 설정
public interface CurrencyExchangeProxy {
    /*
        currency-exchange controller의 있는 꼴 그대로 가져오기
        응답이 json 형태이므로 CurrencyConversion에 매핑됨 (json 요청이 dto에 매핑되는 것과 같음)
    */
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion retrieveExchangeValue(
            @PathVariable("from") String from, @PathVariable("to") String to);
}
