package com.mdh.springcloud.lb;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author madonghao
 * @create 2020-04-08 11:03
 **/
@Component
public class MyLoadBalancer implements LoadBalancer {

    /**
     * 参考
     * com.netflix.loadbalancer.RoundRobinRule#incrementAndGetModulo(int)
     *
     * private AtomicInteger nextServerCyclicCounter;
     * private int incrementAndGetModulo(int modulo) {
     *         for (;;) {
     *             int current = nextServerCyclicCounter.get();
     *             int next = (current + 1) % modulo;
     *             if (nextServerCyclicCounter.compareAndSet(current, next))
     *                 return next;
     *         }
     *     }
     *
     * public final boolean compareAndSet(int expect, int update) {
     *         return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
     *     }
     *
     */

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            // 超过最大值,为0,重新计数 2147483647 Integer.MAX_VALUE
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
            // 自旋锁
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("****第几次访问,次数next:" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
