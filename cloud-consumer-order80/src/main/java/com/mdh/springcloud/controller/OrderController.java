package com.mdh.springcloud.controller;

import com.mdh.springcloud.common.CommonResult;
import com.mdh.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author madonghao
 * @create 2020-03-23 9:29
 **/
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    RestTemplate restTemplate;

    /**
     * http://localhost/consumer/payment/create?serial=madonghao
     *
     * @param payment
     * @return
     */
    @PostMapping("/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    /**
     * http://localhost/consumer/payment/get/1
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
