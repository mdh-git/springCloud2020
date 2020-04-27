package com.mdh.springcloud.entities;

/**
 * @author madonghao
 * @create 2020-04-27 15:21
 **/
public enum ResourceType {

    APPLE(1, "苹果"),
    BANANA(2, "香蕉"),
    ORANGE(3, "橘子"),
    STRAWBERRY(4, "草莓"),
    GRAPE(5, "葡萄");



    ResourceType(Integer type, String name){
        this.type = type;
        this.name = name;
    }


    private Integer type;
    private String name;


    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
