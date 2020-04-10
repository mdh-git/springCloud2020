package com.mdh.springcloud.controller;

import com.mdh.springcloud.common.CommonResult;
import com.mdh.springcloud.entities.Payment;
import com.mdh.springcloud.service.PaymentService;
import io.micrometer.core.instrument.util.TimeUtils;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author madonghao
 * @create 2020-03-21 14:36
 **/
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping(value = "payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element:" + element);
        }
        // 一个微服务下的全部实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }


    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
