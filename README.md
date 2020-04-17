# springCloud2020

## eureka
~~~
最新的
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>


旧版
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
    <version>1.0.5.RELEASE</version>
</dependency>
~~~

## 区别
~~~
组件名          语言        CAP                对外暴露接口

eureka         java        AP(高可用)           HTTP

consul         go          CP(数据一致)         HTTP/DNS

zookeeper      java        CP(数据一致)         客户端


CAP：
    consistency(强一致性)
    availability(高可用)
    partition tolerance(分区容错)

CA： mysql
CP： redis  mongoDB  
AP： DynamoDB
~~~

## hystrix-dashboard里面的坑
~~~
参考 https://www.cnblogs.com/x1mercy/p/9291348.html
     https://blog.csdn.net/ddxd0406/article/details/79643059

网上给出解决这个问题的两种方法：
1、在8001的 application.yml 文件中加入（亲测有效）
   management.endpoints.web.exposure.include=hystrix.stream
2、在监控9001的主启动类里面加入下面的配置（怎么尝试都没成功）
        @Bean
        public ServletRegistrationBean getServlet(){
            HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
            ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
            registrationBean.setLoadOnStartup(1);
            registrationBean.addUrlMappings("/hystrix.stream");
            registrationBean.setName("HystrixMetricsStreamServlet");
            return registrationBean;
        }


监控8001的路径  http://localhost:8001/actuator/hystrix.stream
~~~

## gateway
~~~
参考： https://www.jianshu.com/p/18cd9cec3269

          - id: payment_route2
          # uri: http://localhost:8001
          uri: lb://cloud-payment-service
          predicates:
            Path=/payment/lb/** #断言,路径相匹配的进行路由

刚开始不理解 uri 中为何在服务名称之前加lb://,以为是访问路径http://localhost:9527/payment/lb  最后的lb的意思,
就去掉前面的lb://,只是用后面的服务名,发现不能使用  查阅资料发现都是这样写的  个人猜测是 是LoadBalancer  负载的意思,
去找服务名对应的服务负载提供服务
~~~