package com.internship.scenariosystem;

import com.internship.scenariosystem.repo.OrderRepo;
import com.internship.scenariosystem.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringScenarioSystemApplicationTests {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderRepo orderRepo;

    @Test
    void contextLoads() {
    }

}
