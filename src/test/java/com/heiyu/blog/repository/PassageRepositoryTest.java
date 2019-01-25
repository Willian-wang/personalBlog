package com.heiyu.blog.repository;

import com.heiyu.blog.domain.Passage;
import com.heiyu.blog.service.PassageService;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PassageRepositoryTest {

    @Autowired
    private PassageService passageService;

    @Test
    public  void writePassageTest(){
        Passage passage = new Passage();
        passage.setAuthor("Jayfeather");
        passage.setNodeId(1);
        passage.setText("这是一个测试");
        passage.setTitle("测试");
        assertEquals (true , passageService.wirtePassage(passage));
    }

}
