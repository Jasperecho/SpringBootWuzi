package com.yjj.back.service;


import com.yjj.back.common.Result;
import com.yjj.back.domain.GoodOrder;

import java.util.List;

public interface BuyerService {


    List<GoodOrder> orderInfoById(Long userId);

    Result commitAgain(Integer id,String orderStatu);

    Result applyOrder(GoodOrder goodOrder);
}
