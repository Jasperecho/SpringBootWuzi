package com.yjj.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.yjj.back.domain.GoodOrder;
import com.yjj.back.service.BuyerService;

import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/orderInfo/{userId}")
    @ResponseBody
    public List<GoodOrder> orderInfo(@PathVariable("userId") Long userId){
        return buyerService.orderInfoById(userId);
    }




}
