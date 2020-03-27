package com.mdh.springcloud.controller;

import com.mdh.springcloud.common.CommonResult;
import com.mdh.springcloud.entities.Payment;
import com.mdh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author madonghao
 * @create 2020-03-21 14:36
 **/
@RestController
@Slf4j
public class PaymentController {

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
     * http://localhost:8001/payment/get/1
     *
     * @param id
     * @return
     */
    @GetMapping(value = "payment/get/{id}")
    public CommonResult getPayment(@PathVariable(value = "id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果: " + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功, serverPort:" + serverPort , payment);
        }
        return new CommonResult(444, "没有对应记录,查询ID:" + id, null);
    }

    /**
     * 新增
     * postman http://localhost:8001/payment/create?serial=madonghao
     *
     * @param payment
     * @return
     */
    @PostMapping(value = "payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果: " + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功, serverPort:" + serverPort, result);
        }
        return new CommonResult(444, "插入数据库失败", null);
    }
}
