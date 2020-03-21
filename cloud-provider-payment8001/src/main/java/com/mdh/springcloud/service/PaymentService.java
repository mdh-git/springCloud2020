package com.mdh.springcloud.service;

import com.mdh.springcloud.entities.Payment;

/**
 * @author madonghao
 * @create 2020-03-21 14:37
 **/
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
