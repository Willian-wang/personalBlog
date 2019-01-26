package com.heiyu.blog.repository;

import com.heiyu.blog.domain.Passage;
import com.heiyu.blog.service.PassageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Rollback(false)
public class PassageRepositoryTest {

    @Autowired
    private PassageService passageService;

    @Autowired
    private PassageRepository passageRepository;


    @Test
    public  void writePassageTest(){
        Passage passage = new Passage();
        passage.setAuthor("Jayfeather");
        passage.setNodeId(1);
        passage.setText("测试啊啊啊啊");
        passage.setTitle("测试");
        assertEquals (true , passageService.wirtePassage(passage));
    }


    @Test
    public  void deletPassageTest(){
        Passage passage = new Passage();
        passage.setId(1);
        passage.setRemove(true);
        passage.setUpdateTime(new Date());
        assertEquals(true,passageRepository.deletePassage(passage));
    }


    @Test
    public void getPassageListTest(){
        String a = passageService.getPassageList(2,2);
        assertNotEquals(null ,a);
    }

}
