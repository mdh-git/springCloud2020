package com.mdh.springcloud.service.impl;

import com.mdh.springcloud.entities.Fruit;
import com.mdh.springcloud.entities.ResourceType;
import com.mdh.springcloud.service.FruitService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author madonghao
 * @create 2020-04-27 15:42
 **/
@Service
public class OrangeServiceImpl implements FruitService {
    @Override
    public List<Fruit> getList() {
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit("砂糖桔", ResourceType.ORANGE.getType(), "砂糖桔"));
        list.add(new Fruit("甜橙", ResourceType.ORANGE.getType(), "甜橙"));
        return list;
    }
}
