package com.mdh.springcloud.service.impl;

import com.mdh.springcloud.entities.Fruit;
import com.mdh.springcloud.entities.ResourceType;
import com.mdh.springcloud.service.FruitService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author madonghao
 * @create 2020-04-27 15:32
 **/
@Service
public class BananaServiceImpl implements FruitService {

    @Override
    public List<Fruit> getList() {
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit("仙人蕉", ResourceType.BANANA.getType(), "仙人蕉"));
        list.add(new Fruit("芝麻蕉", ResourceType.BANANA.getType(), "芝麻蕉"));
        return list;
    }
}
