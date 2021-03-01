package com.yzh.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author simple
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder builder = routeLocatorBuilder.routes();
        builder.route("path_route_1",
            r -> r.path("/guonei").uri("http://news.baidu.com/guonei")
        ).build();
        builder.route("path_route_2",
            r -> r.path("/guoji").uri("http://news.baidu.com/guoji")
        ).build();
        return builder.build();
    }
}
