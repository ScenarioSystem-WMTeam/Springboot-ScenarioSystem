package com.internship.scenariosystem.repo;

import com.internship.scenariosystem.model.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrderRepo extends JpaRepository<OrderInfo,Integer> {

    @Query(value = "select user_name,user.user_number,play.play_number,play_name from user,play,order_info where user.user_number=order_info.user_number and play.play_number=order_info.play_number and user.user_number= ?1",nativeQuery = true)
    public List<Map<String,Object>> getAllMyOrder(String userNumber);

    @Query(value = "select user.user_number,user_name,play.play_number,play_name from user,play,order_info where user.user_number=order_info.user_number and play.play_number=order_info.play_number",nativeQuery = true)
    public List<Map<String,Object>> getAllOrder();

    //    查询预定数量
    @Query(value = "select count(*) as order_count from order_info",nativeQuery = true)
    public Map<String,Object> getOrderCount();
}
