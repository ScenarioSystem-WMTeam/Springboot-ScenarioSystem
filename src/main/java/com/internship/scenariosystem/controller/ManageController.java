package com.internship.scenariosystem.controller;

import com.internship.scenariosystem.model.Manage;
import com.internship.scenariosystem.repo.ManageRepo;
import com.internship.scenariosystem.util.JWTHelper;
import com.internship.scenariosystem.util.NeedLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class ManageController {
    @Autowired
    private ManageRepo manageRepo;

    //获取所有管理员列表
    @NeedLogin
    @GetMapping(value = "/get_manage",produces = "application/json;charset=utf-8")
    public List<Manage> getManage(){
        List<Manage> result = manageRepo.getmanages();
        return result;
    }

    //    获取管理员number
    @GetMapping(value = "/get_managenumber",produces = "application/json;charset=utf-8")
    public String  getManageNumber(){
        int re = manageRepo.getManageNumber()+1;
        String result = Integer.toString(re);
        return result;
    }


    //注册
    @PostMapping(value = "/create_manage")
    public Map<String,Object> createManage(@RequestParam(value = "manageNumber",required = true) String manageNumber,
                                         @RequestParam(value = "manageName",required = true) String manageName,
                                         @RequestParam(value = "password",required = true)String password,
                                         @RequestParam(value = "manageType",required = true) String manageType){
        Map<String ,Object> result = new HashMap<>();
        Manage manage = new Manage();
        manage.setManage_number(manageNumber);
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        manage.setManage_password(md5Password);
        manage.setManage_type(manageType);
        manage.setManage_name(manageName);

        manageRepo.save(manage);

        result.put("status","ok");
        result.put("userId",manage.getManage_id());
        return result;
    }

    //    登录
    @PostMapping(value = "/login")
    public Map<String,Object> login(@RequestParam(value = "manageName",required = true)String userName,
                                    @RequestParam(value = "managePassword",required = true)String password){
        Map<String ,Object> result = new HashMap<>();

        List<Manage> manageList = manageRepo.findByManageName(userName);
        if(manageList.size() == 0){
            result.put("status","username or password error");
        }
        Manage manage = manageList.get(0);
        String oldPassword = manage.getManage_password();
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
//        验证密码
        if (md5Password.equals(oldPassword)){
//            JWR获得token
            String token = JWTHelper.createJwtToken(manage);
            result.put("status","ok");
            result.put("token",token);
            return result;
        }else {
            result.put("status","username or password error");
            return result;
        }
    }

    //    查询管理人员总数量
    @GetMapping(value = "/get_managecount",produces = "application/json; charset=utf-8")
    public Map<String,Object> getManageCount(){
        Map<String,Object> result = manageRepo.getManageCount();
        return result;
    }

}
