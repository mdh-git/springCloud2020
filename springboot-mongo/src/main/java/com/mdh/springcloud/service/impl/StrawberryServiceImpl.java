package com.mdh.springcloud.service.impl;

import com.mdh.springcloud.entities.Fruit;
import com.mdh.springcloud.entities.ResourceType;
import com.mdh.springcloud.service.FruitService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author madonghao
 * @create 2020-04-27 15:43
 **/
@Service
public class StrawberryServiceImpl implements FruitService {

    @Override
    public List<Fruit> getList() {
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit("牛奶草莓", ResourceType.STRAWBERRY.getType(), "牛奶草莓"));
        list.add(new Fruit("红颜草莓", ResourceType.STRAWBERRY.getType(), "红颜草莓"));
        return list;
    }
}
