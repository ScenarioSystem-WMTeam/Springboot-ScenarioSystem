package com.internship.scenariosystem.controller;

import com.internship.scenariosystem.model.User;
import com.internship.scenariosystem.repo.UserRepo;
import com.internship.scenariosystem.util.NeedLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserRepo userRepo;

    //注册会员用户，通过手机号
    @PostMapping(value = "/create_user")
    public Map<String,Object> createUser(@RequestParam(value = "userPhone",required = true)String userPhone,
                                         @RequestParam(value = "userName",required = true)String userName,
                                         @RequestParam(value = "userAvatar",required = true)String userAvatar){

        Map<String,Object> result = new HashMap<>();
        User user = new User();
        user.setUser_phone(userPhone);
        user.setUser_name(userName);
        user.setUser_avatar(userAvatar);
        user.setUser_number(userPhone);
        userRepo.save(user);

        result.put("status","ok");
        result.put("userId",user.getUser_id());

        return result;
    }

    //通过手机号注册会员用户，使用的是body post到，实际使用方法
    @PostMapping(value = "/post_user")
    public Map<String,Object> postUser(@RequestBody Map<String,String>map ){

        Map<String,Object> result = new HashMap<>();
        String userPhone= map.get("userPhone");
        String userName= map.get("userName");
        String userAvatar= map.get("userAvatar");

        User user = new User();
        user.setUser_phone(userPhone);
        user.setUser_name(userName);
        user.setUser_avatar(userAvatar);
        user.setUser_number(userPhone);
        userRepo.save(user);

        result.put("status","ok");
        result.put("userId",user.getUser_id());
        result.put("userNumber",user.getUser_number());

        return result;
    }

    //获取我的会员号
    @GetMapping(value = "/get_mynumber",produces = "application/json;charset=utf-8")
    public String getAllMyOrder(@RequestParam(value = "userName",required = true) String userName){
        String result = userRepo.getMyNumber(userName);
        return result;
    }

    //获取所有用户
    @NeedLogin
    @GetMapping(value = "/get_user",produces = "application/json;charset=utf-8")
    public List<User> getProducts(){
        List<User> result = userRepo.getUsers();
        return  result;
    }

    //    查询玩家用户总数量
    @GetMapping(value = "/get_usercount",produces = "application/json; charset=utf-8")
    public Map<String,Object> getUserCount(){
        Map<String,Object> result = userRepo.getUserCount();
        return result;
    }


}
