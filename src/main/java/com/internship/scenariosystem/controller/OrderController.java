package com.internship.scenariosystem.controller;

import com.internship.scenariosystem.model.OrderInfo;
import com.internship.scenariosystem.repo.OrderRepo;
import com.internship.scenariosystem.util.NeedLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderRepo orderRepo;

    //预订剧本（未使用）
    @PostMapping(value = "/post_order")
    public Map<String,Object> createOrder(@RequestParam(value = "userNumber")String userNumber,
                                         @RequestParam(value = "playNumber")String playNumber){

        Map<String,Object> result = new HashMap<>();
        OrderInfo order = new OrderInfo();
        order.setUser_number(userNumber);
        order.setPlay_number(playNumber);
        orderRepo.save(order);

        result.put("status","ok");
        result.put("orderId",order.getOrder_id());
        return result;
    }

    //实际使用post body方法
    @PostMapping(value = "/post_orders")
    public Map<String,Object> createOrders(@RequestBody Map<String,String>map ){

        Map<String,Object> result = new HashMap<>();
        OrderInfo order = new OrderInfo();

        String userNumber= map.get("userNumber");
        String playNumber= map.get("playNumber");
        order.setUser_number(userNumber);
        order.setPlay_number(playNumber);
        orderRepo.save(order);

        result.put("status","ok");
        result.put("orderId",order.getOrder_id());
        return result;
    }

    //获取我的所有预订列表
    @GetMapping(value = "/get_myorders",produces = "application/json;charset=utf-8")
    public List<Map<String,Object>> getAllMyOrder(@RequestParam(value = "userNumber",required = true) String userNumber){
        List<Map<String,Object>> result = orderRepo.getAllMyOrder(userNumber);
        return result;
    }

    //获去预定总数量
    @NeedLogin
    @GetMapping(value = "/get_order",produces = "application/json;charset=utf-8")
    public List<Map<String,Object>> getAllOrder(){
        List<Map<String,Object>> result = orderRepo.getAllOrder();
        return result;
    }

    //    查询预定总数量
    @GetMapping(value = "/get_ordercount",produces = "application/json; charset=utf-8")
    public Map<String,Object> getOrderCount(){
        Map<String,Object> result = orderRepo.getOrderCount();
        return result;
    }

}
