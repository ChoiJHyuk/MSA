package com.rosoa0475.apigateway;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class L1Filter extends AbstractGatewayFilterFactory<L1Filter.Config> {

    //config 클래스에 대한 정보 넘겨야 함
    public L1Filter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        //GatewayFilter의 Filter 메소드 구현 람다식
        return (exchange, chain) -> {
            //pre 부분
            if (config.isPre()) {
                System.out.println("pre local filter 1");
            }
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        //post 부분
                        if (config.isPost()) {

                            System.out.println("post local filter 1");
                        }
                    }));
        };
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Config {
        private boolean pre;
        private boolean post;
    }
}