package com.yjj.back.service;

import com.yjj.back.domain.Good;
import com.yjj.back.domain.GoodOrder;
import com.yjj.back.domain.User;

import java.util.Date;
import java.util.List;

public interface UserService{

    public List<User> findAll();


    User findUsernameAndPwd(String username,String password);

    //分页
//    List<User> getUser(Integer pageNum,Integer pageSize,String statu);


    //查询是采购员的name
    List<User> findName(String statu);

    //查询该采购员购买过的物资
    List<Good> findByName(String name);

    //查询未处理的申请个数
    String countOrder();


    List<GoodOrder> findNameByUserId();

    void updateOrder(Integer id,String orderStatu);

    List<GoodOrder> orderScreen(Date date1, Date date2);


    User getById(Long id);
}

