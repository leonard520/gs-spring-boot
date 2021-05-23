package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @Autowired
    private RefreshEndpoint refreshEndpoint;

    @Autowired
    private GatewayBean gatewayBean;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/refreshScope")
    public String refresh() {
        refreshEndpoint.refresh();
        return "Refresh ok";
    }

    @GetMapping("/getTimeout")
    public String getTimeout() {
        StringBuffer value = new StringBuffer("Hystrix timeout is: ");
        value.append(gatewayBean.getHystrixTimeout());

        return value.toString();
    }
}
