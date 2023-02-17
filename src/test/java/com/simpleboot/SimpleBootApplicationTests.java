package com.simpleboot;

import com.simpleboot.entity.SimpleVideo;
import com.simpleboot.mapper.SimpleVideoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
