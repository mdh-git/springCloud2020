package com.mdh.springcloud.util;

import com.mdh.springcloud.entities.ResourceType;
import com.mdh.springcloud.service.FruitService;
import com.mdh.springcloud.service.impl.*;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author madonghao
 * @create 2020-04-27 15:58
 **/
@Component
public class ResourceTransferFactory {

    @Autowired
    private ApplicationContext applicationContext;

    public FruitService getService(Integer type){
        if(type == ResourceType.APPLE.getType()){
            return applicationContext.getBean(AppleServiceImpl.class);
        } else if(type == ResourceType.BANANA.getType()){
            return applicationContext.getBean(BananaServiceImpl.class);
        } else if(type == ResourceType.GRAPE.getType()){
            return applicationContext.getBean(GrapeServiceImpl.class);
        } else if(type == ResourceType.ORANGE.getType()){
            return applicationContext.getBean(OrangeServiceImpl.class);
        } else if(type == ResourceType.STRAWBERRY.getType()){
            return applicationContext.getBean(StrawberryServiceImpl.class);
        }else {
            throw new IllegalArgumentException("未知的水果类型");
        }
    }

}
