package com.mdh.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author madonghao
 * @create 2020-04-30 11:22
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {
    private String token;
}
