package com.mdh.springcloud.service.impl;

import com.mdh.springcloud.entities.Fruit;
import com.mdh.springcloud.entities.ResourceType;
import com.mdh.springcloud.service.FruitService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author madonghao
 * @create 2020-04-27 15:44
 **/
@Service
public class GrapeServiceImpl implements FruitService {

    @Override
    public List<Fruit> getList() {
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit("红提", ResourceType.GRAPE.getType(), "红提"));
        list.add(new Fruit("夏黑葡萄", ResourceType.GRAPE.getType(), "夏黑葡萄"));
        return list;
    }
}
