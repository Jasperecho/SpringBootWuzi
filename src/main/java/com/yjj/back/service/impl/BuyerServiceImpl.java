package com.yjj.back.service.impl;

import com.yjj.back.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yjj.back.domain.GoodOrder;
import com.yjj.back.mapper.BuyerMapper;
import com.yjj.back.mapper.GoodMapper;
import com.yjj.back.service.BuyerService;

import java.util.List;


@Service("buyerService")
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private BuyerMapper buyerMapper;

    @Override
    public List<GoodOrder> orderInfoById(Long userId) {
        return buyerMapper.orderInfoById(userId);
    }

    @Override
    public Result commitAgain(Integer id,String orderStatu) {
        buyerMapper.commitAgain(id,orderStatu);
        return new Result(200,"success",1);
    }

    @Override
    public Result applyOrder(GoodOrder goodOrder) {
        buyerMapper.applyOrder(goodOrder);
        return new Result(200,"success",1);
    }
}
