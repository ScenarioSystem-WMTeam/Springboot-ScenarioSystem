package com.internship.scenariosystem.controller;

import com.internship.scenariosystem.model.Play;
import com.internship.scenariosystem.repo.PlayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayController {
    @Autowired
    private PlayRepo playRepo;

    @GetMapping(value = "/get_play",produces = "application/json;charset=utf-8")
    public List<Play> getProducts(){
        List<Play> result = playRepo.getPlays();
        return  result;
    }


    @GetMapping(value = "/get_playbytype",produces = "application/json;charset=utf-8")
    public List<Play> getAllPlayByType(@RequestParam(value = "type",required = true) String playType){
        List<Play> result = playRepo.getAllPlay(playType);
        return  result;
    }
}
