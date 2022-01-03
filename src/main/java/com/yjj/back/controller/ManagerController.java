package com.yjj.back.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.yjj.back.common.Result;
import com.yjj.back.domain.User;
import com.yjj.back.vo.UserVo;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.yjj.back.domain.Good;
import com.yjj.back.domain.GoodOrder;
import com.yjj.back.service.GoodService;
import com.yjj.back.service.UserService;

import java.util.Date;
import java.util.List;


@Controller
@CrossOrigin
@RequestMapping("/manage")
public class ManagerController {

    @Autowired
    private UserService userService;

    @Autowired
    private GoodService goodService;

    //添加物资
    @RequestMapping(value = "/addGood", method = RequestMethod.POST)
    @ResponseBody
    public String addGood(@RequestBody Good good) {
        goodService.addGood(good);
        return "success";

    }

    /**
     * 分页查询所有物资
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequiresAuthentication
    @ResponseBody
    @RequestMapping(value = "/good/{pageNum}/{pageSize}",method = RequestMethod.GET)
    public List<Good> pageGood(@PathVariable("pageNum")Integer pageNum, @PathVariable("pageSize")Integer pageSize){

        return goodService.selectPage((pageNum-1)*pageSize,pageSize);

    }

    @GetMapping("/getTotal")
    @ResponseBody
    public int goodTotal(){
        return goodService.getTotal();
    }


    /**
     * 根据id查询物资
     * @param id
     * @return
     */
    @RequestMapping(value = "/findById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Good findById(@PathVariable("id")Integer id){
        return goodService.findById(id);
    }

    /**
     * 修改物资信息
     * @param good
     * @return
     */
    @RequestMapping(value = "/updateGood",method = RequestMethod.POST)
    @ResponseBody
    public String updateGood(@RequestBody Good good){
        goodService.updateGood(good);
        return "success";
    }

    /**
     * 根据id删除当前行数据
     * @param id
     */
    @RequestMapping(value = "/deleteGood/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteGood(@PathVariable("id") Integer id){
        goodService.deleteGood(id);
    }

    /**
     * 返回未处理的申请信息
     * @param orderStatu
     * @param id
     */
    @RequestMapping(value = "/updateOrder/{id}/{orderStatu}",method = RequestMethod.GET)
    @ResponseBody
    public void updateOrder(@PathVariable("orderStatu") String orderStatu,@PathVariable("id")Integer id){
        userService.updateOrder(id,orderStatu);

    }

    /**
     * 查看审批记录
     * @param orderStatu
     * @return
     */
    @GetMapping("/orderRecord")
    @ResponseBody
    public List<GoodOrder> orderRecord(String orderStatu){

        return goodService.orderRecord(orderStatu);
    }

    @GetMapping("/screen/{date1}/{date2}")
    @ResponseBody
    public List<GoodOrder> orderScreen(@PathVariable("date1") Date date1,@PathVariable("date2")Date date2){


        return userService.orderScreen(date1,date2);
    }

    /**
     * 增加采购员
     * @param userVo
     * @return
     */
    @PostMapping("/addBuyer")
    @ResponseBody
    public Result addBuyer(@RequestBody UserVo userVo){


        return userService.addBuyer(userVo);

    }


}
