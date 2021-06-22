package com.internship.scenariosystem.repo;

import com.internship.scenariosystem.model.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface PlayRepo extends JpaRepository<Play,Integer> {

    @Query(value = "select * from play order by play_sort",nativeQuery = true)
    public List<Play> getPlays();

    @Query(value = "select * from play where play_type = ?1",nativeQuery = true)
    public List<Play> getAllPlay(String playType);


    //    按照剧本名称查询
    @Query(value = "select * from play where play_name like %?1%",nativeQuery = true)
    public List<Play> searchPlay(String playName);


    //    获取最大的playNumber
    @Query(value = "select  max(cast(play_number  as SIGNED)) from play",nativeQuery = true)
    public int getPlayNumber();

    //    通过play_number获取数据--查询某个剧本的详情信息
    @Query(value = "select * from play where play_number = ?1",nativeQuery = true)
    public Play getPlayByNumber(String playNumber);

////    通过play_number删除数据
//    @Query(value = "delete from play where play_number = ?1",nativeQuery = true)
//    public void deletePlayByNumber(String playNumber);

    //    查询剧本数量
    @Query(value = "select count(*) as play_count from play",nativeQuery = true)
    public Map<String,Object> getPlayCount();

    //    查询基本分类数量
    @Query(value = "SELECT\n" +
            " sum(play_type = 'easy') AS easy,\n" +
            " sum(play_type = 'middle') AS middle,\n" +
            " sum(play_type = 'difficult')  AS difficult\n" +
            "FROM play",nativeQuery = true)
    public Map<String,Object> getPlayTypeCount();

}
