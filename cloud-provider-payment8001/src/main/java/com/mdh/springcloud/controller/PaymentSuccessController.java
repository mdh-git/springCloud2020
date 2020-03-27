package com.mdh.springcloud.controller;

import com.mdh.springcloud.common.ResponseResult;
import com.mdh.springcloud.entities.Payment;
import com.mdh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author madonghao
 * @create 2020-03-27 14:44
 **/
@RestController
@Slf4j
@ResponseResult
public class PaymentSuccessController {

    @Autowired
    PaymentService paymentService;

    /**
     * 端口号
     * 查看负载均衡的效果
     */
    @Value("${server.port}")
    private String serverPort;

    /**
     * 查询
     * http://localhost:8001/paymentSuccess/get/1
     *
     * @param id
     * @return
     */
    @GetMapping(value = "paymentSuccess/get/{id}")
    public Payment getPayment(@PathVariable(value = "id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果: " + payment);
        if (payment != null) {
            return payment;
        }
        return null;
    }
}
