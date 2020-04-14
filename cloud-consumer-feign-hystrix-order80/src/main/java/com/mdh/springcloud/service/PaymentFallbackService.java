package com.mdh.springcloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author madonghao
 * @create 2020-04-14 17:00
 **/
@Component
public class PaymentFallbackService implements FallbackFactory<PaymentHystrixService> {


    @Override
    public PaymentHystrixService create(Throwable cause) {

        return new PaymentHystrixService(){

            @Override
            public String paymentInfo_OK(Integer id) {
                return "----PaymentFallbackService fall back-paymentInfo_OK,o(╥﹏╥)o";
            }

            @Override
            public String paymentInfo_TimeOut(Integer id) {
                return "----PaymentFallbackService fall back-paymentInfo_TimeOut,o(╥﹏╥)o";
            }
        };
    }
}
