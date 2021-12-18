package com.yjj.back.service.impl;

import com.yjj.back.domain.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yjj.back.domain.Good;
import com.yjj.back.domain.GoodOrder;
import com.yjj.back.mapper.GoodMapper;
import com.yjj.back.service.GoodService;


import java.util.List;

@Service("goodService")
public class GoodServiceImpl implements GoodService {


    @Autowired
    private GoodMapper goodMapper;


    @Override
    public List<Good> getGood() {
        return goodMapper.selectGood();
    }

    @Override
    public List<Good> selectPage(Integer pageNum,Integer pageSize) {

        return goodMapper.selectPage(pageNum,pageSize);
    }


    /**
     * 添加物资
     * @param good
     * @return
     */
    @Override
    public void addGood(Good good) {
        goodMapper.addGood(good);
    }

    @Override
    public Good findById(Integer id) {

        return goodMapper.findById(id);
    }

    @Override
    public void updateGood(Good good) {
         goodMapper.updateGood(good);
    }

    @Override
    public void deleteGood(Integer id) {
        goodMapper.deleteGood(id);
    }

    @Override
    public List<GoodOrder> orderRecord(String orderStatu) {
        return goodMapper.orderRecord("审核中");
    }

    @Override
    public int getTotal() {
        return goodMapper.getTotal();
    }


}
