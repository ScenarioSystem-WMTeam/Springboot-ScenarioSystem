package com.internship.scenariosystem.controller;

import com.internship.scenariosystem.model.OrderInfo;
import com.internship.scenariosystem.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    private OrderRepo orderRepo;

    @PostMapping(value = "/post_order")
    public Map<String,Object> createUser(@RequestParam(value = "userNumber",required = true)String userNumber,
                                         @RequestParam(value = "playNumber",required = true)String playNumber){

        Map<String,Object> result = new HashMap<>();
        OrderInfo order = new OrderInfo();
        order.setUser_number(userNumber);
        order.setPlay_number(playNumber);

        orderRepo.save(order);
        result.put("status","ok");
        result.put("orderId",order.getOrder_id());

        return result;
    }

}
