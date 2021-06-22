package com.internship.scenariosystem.repo;

import com.internship.scenariosystem.model.Manage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ManageRepo extends JpaRepository<Manage,Integer> {
    @Query(value = "select * from manage where manage_name = ?1",nativeQuery = true)
    public List<Manage> findByManageName(String manageName);

    @Query(value = "select * from manage",nativeQuery = true)
    public List<Manage> getmanages();

    @Query(value = "select  max(cast(manage_number  as SIGNED)) from manage",nativeQuery = true)
    public int getManageNumber();

    //    查询管理人员数量
    @Query(value = "select count(*) as manage_count from manage",nativeQuery = true)
    public Map<String,Object> getManageCount();
}
