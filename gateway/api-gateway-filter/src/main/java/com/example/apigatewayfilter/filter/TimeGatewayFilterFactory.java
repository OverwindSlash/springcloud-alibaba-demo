package com.example.apigatewayfilter.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
public class TimeGatewayFilterFactory extends AbstractGatewayFilterFactory<TimeGatewayFilterFactory.Config> {
    private static final String BEGIN_TIME = "beginTime";
    public TimeGatewayFilterFactory() {
        super(TimeGatewayFilterFactory.Config.class);
    }

    //读取配置文件中的参数 赋值到 配置类中
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("show");
    }

    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                if (!config.show){ // 如果配置类中的show为false，表示放行
                    return chain.filter(exchange);
                }
                // pre逻辑
                exchange.getAttributes().put(BEGIN_TIME, System.currentTimeMillis());
                return chain.filter(exchange).then(Mono.fromRunnable(()->{
                    // post逻辑
                    Long startTime = exchange.getAttribute(BEGIN_TIME);
                    if (startTime != null) {
                        System.out.println(exchange.getRequest().getURI() + " 请求耗时: " + (System.currentTimeMillis() - startTime) + "ms");
                    }
                }));
            }
        };
    }

    @Setter
    @Getter
    static class Config{
        private boolean show;
    }
}
