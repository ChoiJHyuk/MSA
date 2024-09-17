package com.rosoa0475.currencyexchange;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CurcuitBreakerController {
    /*
        fallbackMethod는 같은 클래스 내에 있어야 한다.
        retry는 서버가 잠시 다운됐을 때 유용하다.
    */
    //@Retry(name = "sample-api", fallbackMethod = "hardcodedresponse")
    /*
        지속적으로 서버가 다운되었을 때, 기존의 메소드를 안 거치고 대체 메소드에서 바로 응답을 보낸다. (장기간 서버 다운때 유용)
        이를 회로를 오픈했다고 표현한다.
    */
    //@CircuitBreaker(name = "default", fallbackMethod = "hardcodedresponse")
    /*
        속도 제한을 위한 어노테이션으로 특정 시간 동안 특정 API에 대한 호출 수를 제한하는 것이다.
        예를 들어, 10초 동안 sample-api에 10000번의 호출만 허용할 수 있다.
     */
    @RateLimiter(name = "default", fallbackMethod = "hardcodedresponse")
    /*
        @Bulkhead는 한 번에 허용되는 동시 호출 수를 제한한다.
    */
    @Bulkhead(name = "default")
    @GetMapping("/sample-api")
    public String sampleApi() {
        log.info("Sample Api call received");
        /*ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
        return forEntity.getBody();*/
        return "sample-api";
    }

    //예외를 인자로 받아야 한다. 기존의 메소드에서 발생한 예외를 처리한 것과 같은 의미이다.
    public String hardcodedresponse(Exception ex) {
        return "fallback-response";
    }
}
