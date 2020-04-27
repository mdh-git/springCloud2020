package com.mdh.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author madonghao
 * @create 2020-04-27 15:17
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fruit {

    private String name;
    private Integer resourceType;
    private String introduction;

}
