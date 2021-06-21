package com.internship.scenariosystem;

import com.internship.scenariosystem.model.OrderInfo;
import com.internship.scenariosystem.repo.OrderRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderTest {
    @Autowired
    private OrderRepo orderRepo;
    @Test
    void  testorder(){
        orderRepo.deleteAll();

        OrderInfo order = new OrderInfo();
        order.setPlay_number("20210101");
        order.setUser_number("5060");
        orderRepo.save(order);
    }
}
