package com.internship.scenariosystem;

import com.internship.scenariosystem.model.Manage;
import com.internship.scenariosystem.repo.ManageRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManageTest {
    @Autowired
    private ManageRepo manageRepo;
    @Test
    void  testmanage(){
        manageRepo.deleteAll();
        Manage manage = new Manage();
        manage.setManage_name("admin");
        manage.setManage_password("e10adc3949ba59abbe56e057f20f883e");
        manage.setManage_type("超级管理员");
        manage.setManage_number("20181101");
        manageRepo.save(manage);

        Manage manage1 = new Manage();
        manage1.setManage_name("hhh");
        manage1.setManage_password("e10adc3949ba59abbe56e057f20f883e");
        manage1.setManage_type("普通管理员");
        manage1.setManage_number("20181102");
        manageRepo.save(manage1);

        Manage manage3 = new Manage();
        manage3.setManage_name("admin");
        manage3.setManage_password("e10adc3949ba59abbe56e057f20f883e");
        manage3.setManage_type("普通管理员");
        manage3.setManage_number("20181103");
        manageRepo.save(manage3);
    }
}

