package com.mdh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author madonghao
 * @create 2020-04-03 10:48
 **/
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    /**
     * http://localhost:8006/payment/consul
     *
     * @return
     */
    @RequestMapping(value = "payment/consul")
    public String paymentZk() {
        return "SpringCloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
