package com.yjj.back.service;

import com.yjj.back.domain.PageInfo;
import com.yjj.back.domain.Good;
import com.yjj.back.domain.GoodOrder;

import java.util.List;


public interface GoodService {


    //查询物资
    List<Good> getGood();

    List<Good> selectPage(Integer pageNum,Integer pageSize);

    //添加物资
    void addGood(Good good);


    Good findById(Integer id);

    void updateGood(Good good);

    void deleteGood(Integer id);

    List<GoodOrder> orderRecord(String orderStatu);


    int getTotal();
}

