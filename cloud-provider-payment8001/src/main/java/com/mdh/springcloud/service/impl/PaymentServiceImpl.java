package com.mdh.springcloud.service.impl;

import com.mdh.springcloud.dao.PaymentDao;
import com.mdh.springcloud.entities.Payment;
import com.mdh.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author madonghao
 * @create 2020-03-21 14:40
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
