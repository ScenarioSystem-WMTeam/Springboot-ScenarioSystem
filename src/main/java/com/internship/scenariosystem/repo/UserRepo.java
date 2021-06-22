package com.internship.scenariosystem.repo;

import com.internship.scenariosystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query(value = "select user_number from user where user_name = ?1",nativeQuery = true)
    String getMyNumber(String userName);


    @Query(value = "select * from user",nativeQuery = true)
    public List<User> getUsers();

    //    查询玩家用户数量
    @Query(value = "select count(*) as user_count from user",nativeQuery = true)
    public Map<String,Object> getUserCount();

    @Query(value = "select * from user where user_name like %?1% ",nativeQuery = true)
    public List<User> findUserByName(String userName);

}
