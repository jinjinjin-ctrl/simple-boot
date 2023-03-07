package com.simpleboot;

import com.simpleboot.entity.SimpleVideo;
import com.simpleboot.entity.UserDetail;
import com.simpleboot.entity.vo.Result;
import com.simpleboot.mapper.SimpleVideoMapper;
import com.simpleboot.service.SimpleUserService;
import com.simpleboot.utils.JwtUtil;
import com.simpleboot.utils.Sha1Util;
import com.simpleboot.utils.isValidUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class SimpleBootApplicationTests {
    @Autowired
    private SimpleVideoMapper videoMapper;

    @Autowired
    private SimpleUserService userService;

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
        System.out.println("密码:" + s);

        System.out.println("密码:" + s + "时间" + (stime - stime1));

        System.out.println(s == s1);
        System.out.println(s.equals(s1));

        String a = null;
        System.out.println(a == "");
        System.out.println(a == null);

        System.out.println(new Date());
    }

    @Test
    void testPassword(){
        UserDetail userDetails = userService.loginUser("278268@qq.com");
        String createtoken = JwtUtil.createtoken(userDetails);
        System.out.println(createtoken);

    }
    @Test
    void contextNull() {


        String userName = "1236564@qq.com";
        String userPassword = "";
        if (userName == "" || userName == null) {
            System.out.println("创建用户邮箱为空");
        }
        if (!isValidUtil.checkEmail(userName)) {
            System.out.println("用户邮箱格式错误");
        }
        if (userPassword == "" || userPassword == null) {
            System.out.println("创建用户密码为空");
        }
        Result result = new Result();
        result.setData("user_id:+"+"\"1\""+" token:"+"\"qweqwe123\"");
        System.out.println(result);
        System.out.println(Sha1Util.inputPassFormPass("123456").equals("7C4A8D09CA3762AF61E59520943DC26494F8941B"));


    }


}
