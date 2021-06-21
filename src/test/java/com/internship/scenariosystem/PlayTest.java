package com.internship.scenariosystem;

import com.internship.scenariosystem.model.Play;
import com.internship.scenariosystem.repo.PlayRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class PlayTest {
    @Autowired
    public PlayRepo playRepo;

    @Test
    void TestPlay(){
//        playRepo.deleteAll();

//        Play play = new Play();
//        play.setPlay_number("20210101");
//        play.setPlay_name("本格推理");
//        play.setPlay_detail("时间的长河滚滚向前，就像河流，冲刷着一切美好或痛苦的回忆。待尘埃落定，看一世芳华。《年轮》2019年最佳剧本，时生社 倾情推荐。");
//        play.setPlay_photo("https://scenariosystem.oss-cn-hangzhou.aliyuncs.com/playphoto/bgtl/mmexport1623986556540.jpg");
//        play.setPlay_price(new BigDecimal("88"));
//        play.setPlay_sort(1);
//        play.setPlay_type("difficult");
//        play.setPlay_detail_photo("https://scenariosystem.oss-cn-hangzhou.aliyuncs.com/playphoto/bgtl/mmexport1623986560976.jpg");
//        play.setPlay_people("3男2女");
//        playRepo.save(play);

//        Play play1 = new Play();
//        play1.setPlay_number("20210102");
//        play1.setPlay_name("北国之春");
//        play1.setPlay_detail("这个春天，我想慢慢地告别。这座城市，承载了太多太多…");
//        play1.setPlay_photo("https://scenariosystem.oss-cn-hangzhou.aliyuncs.com/playphoto/bgzc/mmexport1623986235532.jpg");
//        play1.setPlay_price(new BigDecimal("78"));
//        play1.setPlay_sort(2);
//        play1.setPlay_type("easy");
//        play1.setPlay_detail_photo("https://scenariosystem.oss-cn-hangzhou.aliyuncs.com/playphoto/bgzc/mmexport1623986238009.jpg");
//        play1.setPlay_people("3男3女");
//        playRepo.save(play1);

        Play play2 = new Play();
        play2.setPlay_number("20210103");
        play2.setPlay_name("反对无效");
        play2.setPlay_detail("这一事件经过发酵后，成为都市怪谈,让M市增添不少神秘色彩");
        play2.setPlay_photo("https://scenariosystem.oss-cn-hangzhou.aliyuncs.com/playphoto/fdwx/mmexport1623986096541.jpg");
        play2.setPlay_price(new BigDecimal("68"));
        play2.setPlay_sort(2);
        play2.setPlay_type("middle");
        play2.setPlay_detail_photo("https://scenariosystem.oss-cn-hangzhou.aliyuncs.com/playphoto/fdwx/mmexport1623986099376.jpg");
        play2.setPlay_people("4男4女");
        playRepo.save(play2);

    }
}
