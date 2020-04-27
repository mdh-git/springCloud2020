package com.mdh.springcloud.service.impl;

import com.mdh.springcloud.entities.Fruit;
import com.mdh.springcloud.entities.ResourceType;
import com.mdh.springcloud.service.FruitService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author madonghao
 * @create 2020-04-27 15:26
 **/
@Service
public class AppleServiceImpl implements FruitService {

    @Override
    public List<Fruit> getList() {
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit("红富士", ResourceType.APPLE.getType(), "红富士"));
        list.add(new Fruit("阿克苏", ResourceType.APPLE.getType(), "阿克苏"));
        list.add(new Fruit("蛇果", ResourceType.APPLE.getType(), "蛇果"));
        return list;
    }
}
