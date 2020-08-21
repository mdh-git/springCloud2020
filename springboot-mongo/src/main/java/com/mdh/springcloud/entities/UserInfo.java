package com.mdh.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author madonghao
 * @create 2020-04-30 13:17
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private String avatar;
    private String introduction;
    private String name;
    private List<String> roles;
}
