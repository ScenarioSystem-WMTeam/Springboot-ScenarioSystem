package com.internship.scenariosystem;

import com.internship.scenariosystem.repo.OrderRepo;
import com.internship.scenariosystem.repo.PlayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringScenarioSystemApplication {
    @Autowired
    private PlayRepo playRepo;
    @Autowired
    private OrderRepo orderRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringScenarioSystemApplication.class, args);
    }

}
