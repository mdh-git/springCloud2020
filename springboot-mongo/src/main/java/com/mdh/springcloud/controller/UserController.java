package com.mdh.springcloud.controller;

import com.mdh.springcloud.common.CommonResult;
import com.mdh.springcloud.common.ResultCode;
import com.mdh.springcloud.entities.Fruit;
import com.mdh.springcloud.entities.LoginInfo;
import com.mdh.springcloud.entities.User;
import com.mdh.springcloud.entities.UserInfo;
import com.mdh.springcloud.service.FruitService;
import com.mdh.springcloud.util.ResourceTransferFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author madonghao
 * @create 2020-04-29 20:49
 **/
@RestController
public class UserController {

    @Autowired
    ResourceTransferFactory resourceTransferFactory;

    @PostMapping("/user/login")
    public CommonResult<LoginInfo> login(@RequestBody User user){
        CommonResult result = new CommonResult();
        result.setCode(20000);
        result.setData(new LoginInfo("admin-token"));
        return result;
    }

    @GetMapping("/user/info")
    public CommonResult<UserInfo> getUserInfo(@RequestParam String token){
        CommonResult result = new CommonResult();
        result.setCode(20000);
        UserInfo userInfo = new UserInfo();
        userInfo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        userInfo.setIntroduction("I am a super administrator");
        userInfo.setName("Super Admin");
        userInfo.setRoles(Arrays.asList("admin"));
        result.setData(userInfo);
        return result;
    }

    @GetMapping("/fruit/getList")
    public List<Fruit> getList(@RequestParam Integer id){
        FruitService service = resourceTransferFactory.getService(id);
        return service.getList();
    }
}
