package com.rosoa0475.apigateway;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ApiGatewayConfiguration {

    private final L1Filter l1Filter;

    @Bean
    public RouteLocator garewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                //localhost:8756/get이 http://httpbin.org:80으로 포워딩된다.
                .route(predicateSpec -> predicateSpec.path("/get")
                        .filters(filterSpec -> filterSpec.addRequestHeader("Header", "Hvalue")
                                .addRequestParameter("Param", "Pvalue"))
                        .uri("http://httpbin.org:80"))
                .route(predicateSpec -> predicateSpec.path("/currency-exchange/**")
                        /*
                            lb://가 붙으면 /currency-exchange/로 시작하는 요청을 Eureka를 통해 인스턴스를 조회하고,
                            로드밸런싱을 수행하면서 포워딩된다.
                        */
                        .uri("lb://currency-exchange"))
                .route(p -> p.path("/currency-conversion/**")
                        .filters(f->f.filter(l1Filter.apply(new L1Filter.Config(true, true))))
                        .uri("lb://currency-conversion"))
                .route(p -> p.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion"))
                .build();
    }
}
