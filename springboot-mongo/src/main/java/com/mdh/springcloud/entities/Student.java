package com.mdh.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author madonghao
 * @create 2020-04-27 13:43
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Serializable {

    private Long id;

    private String name;

    private String sex;

    private String age;

    private String introduce;
}
