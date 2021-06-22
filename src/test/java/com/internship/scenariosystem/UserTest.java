package com.internship.scenariosystem;

import com.internship.scenariosystem.model.User;
import com.internship.scenariosystem.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserRepo userRepo;

    @Test
    void testuser(){
//        userRepo.deleteAll();

//        User user = new User();
//        user.setUser_number("5060");
//        user.setUser_avatar("https://scenariosystem.oss-cn-hangzhou.aliyuncs.com/avatarphoto/20210529_184326.jpg");
//        user.setUser_consume(new BigDecimal("56"));
//        user.setUser_name("bobox");
//        user.setUser_phone("18200511018");
//        userRepo.save(user);

//        User user1 = new User();
//        user1.setUser_avatar("https://scenariosystem.oss-cn-hangzhou.aliyuncs.com/avatarphoto/20210529_184326.jpg");
//        user1.setUser_name("bobox");
//        user1.setUser_phone("19180864060");
//        userRepo.save(user1);
    }
}
