package com.internship.scenariosystem.repo;

import com.internship.scenariosystem.model.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderInfo,Integer> {
}
