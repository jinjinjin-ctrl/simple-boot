package com.simpleboot;

import com.simpleboot.entity.SimpleVideo;
import com.simpleboot.mapper.SimpleVideoMapper;
import com.simpleboot.utils.Sha1Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class SimpleBootApplicationTests {
    @Autowired
    private SimpleVideoMapper videoMapper;
    @Test
    void contextLoads() {
            System.out.println(("----- selectAll method test ------"));
            List<SimpleVideo> userList = videoMapper.selectList(null);
//            Assert.assertEquals(5, userList.size());
            userList.forEach(System.out::println);
    }
    @Test
    void contextSHA1() {
        long stime = System.currentTimeMillis();
        String s = Sha1Util.inputPassFormPass("a2018117031.");

        String s1 = Sha1Util.inputPassFormPass("a2018117031.");
        long stime1 = System.currentTimeMillis();
        System.out.println("密码:"+ s);

        System.out.println("密码:"+ s + "时间"+ (stime-stime1));

        System.out.println(s == s1);
        System.out.println(s.equals(s1));

        String a =null;
        System.out.println(a == "");
        System.out.println(a == null);

        System.out.println(new Date());
    }



}
