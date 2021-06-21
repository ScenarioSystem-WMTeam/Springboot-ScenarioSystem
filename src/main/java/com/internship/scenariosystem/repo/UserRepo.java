package com.internship.scenariosystem.repo;

import com.internship.scenariosystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
