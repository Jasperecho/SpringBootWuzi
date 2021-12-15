package com.yjj.back.service;


import com.yjj.back.domain.GoodOrder;

import java.util.List;

public interface BuyerService {


    List<GoodOrder> orderInfoById(Long userId);
}
