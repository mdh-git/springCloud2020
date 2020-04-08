package com.mdh.springcloud.service;

import com.mdh.springcloud.common.CommonResult;
import com.mdh.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author madonghao
 * @create 2020-04-08 9:20
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "payment/get/{id}")
    CommonResult<Payment> getPayment(@PathVariable(value = "id") Long id);
}
