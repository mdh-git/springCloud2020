package com.mdh.springcloud.service;

import com.mdh.springcloud.entities.Fruit;

import java.util.List;

/**
 * @author madonghao
 * @create 2020-04-27 15:28
 **/
public interface FruitService {

    List<Fruit> getList();
}
