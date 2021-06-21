package com.internship.scenariosystem.repo;

import com.internship.scenariosystem.model.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayRepo extends JpaRepository<Play,Integer> {

    @Query(value = "select * from play",nativeQuery = true)
    public List<Play> getPlays();

    @Query(value = "select * from play where play_type = ?1",nativeQuery = true)
    public List<Play> getAllPlay(String playType);

}
