package com.example.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@RefreshScope
@Service
public class GatewayBean {

    @Value("${hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds}")
    private int hystrixTimeout;

    public int getHystrixTimeout() {
        return hystrixTimeout;
    }
}
