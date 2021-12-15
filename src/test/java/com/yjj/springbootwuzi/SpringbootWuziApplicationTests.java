package com.yjj.springbootwuzi;


import com.yjj.back.mapper.GoodMapper;
import com.yjj.back.mapper.UserMapper;
import com.yjj.back.service.GoodService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootWuziApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GoodMapper goodMapper;

    @Autowired
    private GoodService goodService;


    @Test
    public void contset(){

    }


}
