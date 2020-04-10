package com.mdh.springcloud.controller;

import com.mdh.springcloud.common.CommonResult;
import com.mdh.springcloud.entities.Payment;
import com.mdh.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author madonghao
 * @create 2020-04-08 9:19
 **/
@RestController
@Slf4j
public class OrderFeignClientController {

    @Resource
    PaymentFeignService paymentFeignService;

    /**
     * http://localhost/consumer/payment/get/1
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        log.info("FeignClient 80 调用成功");
        return paymentFeignService.getPayment(id);
    }


    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // openfeign-ribbon, 客户端一般默认等待1秒钟
        log.info("FeignClient 80 超时");
        return paymentFeignService.paymentFeignTimeout();
    }
}
