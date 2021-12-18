package com.yjj.back.service.impl;

import com.yjj.back.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import com.yjj.back.domain.Good;
import com.yjj.back.domain.GoodOrder;
import com.yjj.back.domain.User;
import com.yjj.back.mapper.UserMapper;
import com.yjj.back.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;


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
    @Override
    public List<User> selectUserPage(Integer pageNum,Integer pageSize,String statu) {

        return userMapper.selectUserPage( pageNum, pageSize,statu);
    }


    @Override
    public List<User> findName(String statu) {
        return userMapper.findName(statu);
    }

    @Override
    public List<Good> findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public String countOrder(String orderStatu) {
        return userMapper.countOrder("审核中");
    }


    @Override
    public List<GoodOrder> findNameByUserId(String orderStatu) {
        return userMapper.findNameByUserId("审核中");
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

    @Override
    public int getTotal(String statu) {
        return userMapper.getTotal(statu);
    }

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    @Override
    public Result updatePersonal(User user) {
        if (user==null){
            return new Result(400,"修改失败",0);
        }else {
            userMapper.updatePersonal(user);
            return new Result(200,"success",1);
        }

    }


}
