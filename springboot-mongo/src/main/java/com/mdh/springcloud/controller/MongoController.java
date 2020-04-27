package com.mdh.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author madonghao
 * @create 2020-04-27 13:27
 **/
@RestController
@RequestMapping("/mongo")
public class MongoController {


    @GetMapping("/getMongoDb")
    public String getMongoDb(){
        return "hello mongo";
    }

}
