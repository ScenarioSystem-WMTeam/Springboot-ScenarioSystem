package com.internship.scenariosystem.controller;

import com.internship.scenariosystem.model.Play;
import com.internship.scenariosystem.repo.PlayRepo;
import com.internship.scenariosystem.util.AliyunOssHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class PlayController {
    @Autowired
    private PlayRepo playRepo;

    //获取剧本排行
    @GetMapping(value = "/get_play",produces = "application/json;charset=utf-8")
    public List<Play> getProducts(){
        List<Play> result = playRepo.getPlays();
        return  result;
    }

   //通过类型获取剧本
    @GetMapping(value = "/get_playbytype",produces = "application/json;charset=utf-8")
    public List<Play> getAllPlayByType(@RequestParam(value = "type",required = true) String playType){
        List<Play> result = playRepo.getAllPlay(playType);
        return  result;
    }


    //    根据剧本名称查询剧本
    @GetMapping(value = "/search_play",produces = "application/json;charset=utf-8")
    public List<Play> searchPlay(@RequestParam(value = "playName",required = true) String playName){
        List<Play> result = playRepo.searchPlay(playName);
        return result;
    }


    //    获取剧本number--实现剧本number自增
    @GetMapping(value = "/get_playnumber",produces = "application/json;charset=utf-8")
    public String  getPlayNumber(){
        int re = playRepo.getPlayNumber()+1;
        String result = Integer.toString(re);
        return result;
    }

    //    剧本新增
//将图片传到阿里云
    @PostMapping(value = "/upload_image",produces = "application/json;charset=utf-8")
    public Map<String,Object> uploadImage(@RequestParam(value = "imageFile",required = true) MultipartFile imageFile) throws IOException {
        //      存到阿里云中
        String imageUrl = AliyunOssHelper.uploadImage(imageFile);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("status","ok");
        result.put("imageUrl",imageUrl);
        return result;
    }
    //    保存到数据库
    @CrossOrigin
    @PostMapping(value = "/add_play", produces = "application/json; charset=utf-8")
    public Map<String, Object> saveProduct(@RequestParam(value = "playNumber", required = true) String playNumber,
                                           @RequestParam(value = "playName", required = true) String playName,
                                           @RequestParam(value = "playDetail", required = true) String playDetail,
                                           @RequestParam(value = "playPhoto", required = true) String playPhoto,
                                           @RequestParam(value = "playDetailphoto", required = true) String playDetailphoto,
                                           @RequestParam(value = "playPrice", required = true) BigDecimal playPrice,
                                           @RequestParam(value = "playType", required = true) String playType,
                                           @RequestParam(value = "playPeople", required = true) String playPeople,
                                           @RequestParam(value = "playSort", required = true) Integer playSort) {
        Play play = new Play();
        play.setPlay_number(playNumber);
        play.setPlay_name(playName);
        play.setPlay_detail(playDetail);
        play.setPlay_photo(playPhoto);
        play.setPlay_detail_photo(playDetailphoto);
        play.setPlay_price(playPrice);
        play.setPlay_type(playType);
        play.setPlay_people(playPeople);
        play.setPlay_sort(playSort);
        //        save实现在数据库中添加了数据
        playRepo.save(play);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", "ok");
        result.put("playid",play.getPlay_id());
        return result;
    }

    //    更改编号---即排序
    @PostMapping(value = "/change_sort", produces = "application/json; charset=utf-8")
    public Map<String, Object> changeOrder(@RequestParam(value = "playNumber", required = true) String  playNumber,
                                           @RequestParam(value = "playSort", required = true) Integer playSort) {
        Play play = playRepo.getPlayByNumber(playNumber);
        play.setPlay_sort(playSort);
        playRepo.save(play);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", "ok");
        return result;
    }

    //删除剧本
    @PostMapping(value = "/delete_play",produces = "application/json; charset=utf-8")
    public Map<String ,Object> deletePlay(@RequestParam(value = "playNumber", required = true) String  playNumber){
//        playRepo.deletePlayByNumber(playNumber);
        Play play = playRepo.getPlayByNumber(playNumber);
        Integer play_id = play.getPlay_id();
        playRepo.deleteById(play_id);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", "ok");
        return result;
    }

    //根据剧本number查询获取剧本信息
    @GetMapping(value = "/show_play",produces = "application/json;charset=utf-8")
    public Map<String ,Object> showPlay(@RequestParam(value = "playNumber",required = true)String playNumber){
        Play play = playRepo.getPlayByNumber(playNumber);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("play",play);
        result.put("status", "ok");
        return result;
    }


    //    修改剧本内容
    @CrossOrigin
    @PostMapping(value = "/change_play", produces = "application/json; charset=utf-8")
    public Map<String, Object> changePlay(@RequestParam(value = "playNumber", required = true) String playNumber,
                                          @RequestParam(value = "playName", required = true) String playName,
                                          @RequestParam(value = "playDetail", required = true) String playDetail,
                                          @RequestParam(value = "playPhoto", required = true) String playPhoto,
                                          @RequestParam(value = "playDetailphoto", required = true) String playDetailphoto,
                                          @RequestParam(value = "playPrice", required = true) BigDecimal playPrice,
                                          @RequestParam(value = "playType", required = true) String playType,
                                          @RequestParam(value = "playPeople", required = true) String playPeople) {
        Play play = playRepo.getPlayByNumber(playNumber);
        play.setPlay_number(playNumber);
        play.setPlay_name(playName);
        play.setPlay_detail(playDetail);
        play.setPlay_photo(playPhoto);
        play.setPlay_detail_photo(playDetailphoto);
        play.setPlay_price(playPrice);
        play.setPlay_type(playType);
        play.setPlay_people(playPeople);
        //        save实现在数据库中添加了数据
        playRepo.save(play);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", "ok");
        result.put("playid",play.getPlay_id());
        return result;
    }

    //    查询剧本总数量
    @GetMapping(value = "/get_playcount",produces = "application/json; charset=utf-8")
    public Map<String,Object> getPlayCount(){
        Map<String,Object> result = playRepo.getPlayCount();
        return result;
    }

    //    查询剧本分类数量
    @GetMapping(value = "/get_playtypecount",produces = "application/json; charset=utf-8")
    public Map<String ,Object> getPlayTypeCount(){
        Map<String ,Object> result = playRepo.getPlayTypeCount();
        return result;
    }
}
