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