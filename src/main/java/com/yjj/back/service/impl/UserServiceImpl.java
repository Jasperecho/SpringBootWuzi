package com.yjj.back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import com.yjj.back.domain.Good;
import com.yjj.back.domain.GoodOrder;
import com.yjj.back.domain.User;
import com.yjj.back.mapper.UserMapper;
import com.yjj.back.service.UserService;


import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public List<User> findAll() {

        return userMapper.findAll();

    }

    @Override
    public User findUsernameAndPwd(String username, String password) {
        String key = "user_" + username;
        ValueOperations<String ,User> operations = redisTemplate.opsForValue();
        boolean haskey = redisTemplate.hasKey(key);
        if (haskey){
            User user = operations.get(key);
            System.out.println("从缓存中拿" + user);
            System.out.println("------------");
            return user;
        }else {
            User user = userMapper.findUsernameAndPwd(username,password);
            if (user==null){
                return null;
            }else {
                System.out.println("数据库中："+user);
                System.out.println("------------");

                operations.set(key,user,1, TimeUnit.HOURS);
                return user;
            }

        }

    }

    //分页查询采购员
//    @Override
//    public List<User> getUser(Integer pageNum,Integer pageSize,String statu) {
//        PageHelper.startPage(pageNum,pageSize);
//
//        return userMapper.selectUser(statu);
//    }


    @Override
    public List<User> findName(String statu) {
        return userMapper.findName(statu);
    }

    @Override
    public List<Good> findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public String countOrder() {
        return userMapper.countOrder();
    }


    @Override
    public List<GoodOrder> findNameByUserId() {
        return userMapper.findNameByUserId();
    }


    @Override
    public void updateOrder(Integer id,String orderStatu) {
        userMapper.updateOrder(id,orderStatu);
    }

    @Override
    public List<GoodOrder> orderScreen(Date date1, Date date2) {
        return userMapper.orderScreen(date1,date2);
    }

    @Override
    public User getById(Long id) {
        return userMapper.getById(id);
    }


}
