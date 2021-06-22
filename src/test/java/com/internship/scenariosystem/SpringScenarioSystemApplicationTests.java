package com.internship.scenariosystem;

import com.internship.scenariosystem.model.User;
import com.internship.scenariosystem.repo.OrderRepo;
import com.internship.scenariosystem.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SpringScenarioSystemApplicationTests {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderRepo orderRepo;

    @Test
    void contextLoads() {
    }
    @Test
    void testUser(){
        //断言测试：此时数据库有两条数据
		assertEquals(2,userRepo.count());

		List<User> userList = userRepo.findUserByName("bobox");
		User bobox = userList.get(0);

//		assertTrue(customerList.size() == 2);
		assertEquals(bobox.getUser_name(),"bobox");
//		assertEquals(bae.getSeqNumber(),"111111");

    }

}
