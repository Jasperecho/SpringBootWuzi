package com.yjj.back.controller;

import com.yjj.back.common.Result;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.yjj.back.domain.Good;
import com.yjj.back.domain.GoodOrder;
import com.yjj.back.domain.User;
import com.yjj.back.service.UserService;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    //查询user表信息
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAll() {
        List<User> userList = userService.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }
//    /**
//     * 登录
//     * @param username
//     * @param password
//     * @return 返回success用于判断
//     */
//    @RequestMapping(value = "/login/{username}/{password}",method = RequestMethod.POST)
//    @ResponseBody
//    public String login(@PathVariable String username, @PathVariable String password) {
//        User user = userService.findUsernameAndPwd(username, password);
//        if (user!=null && user.getStatu().equals("管理员")){
//            return "manager_success";
//        }else if (user!=null && user.getStatu().equals("采购员")){
//            return "buyer_success";
//        }else {
//            return "false";
//        }
//    }

    /**
     * 查询是采购员的name
     */

    @RequestMapping(value = "/findName",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findName(){

        List<User> name = userService.findName("采购员");
        return name;

    }

    @ResponseBody
    @RequestMapping(value = "/info/{pageNum}/{pageSize}",method = RequestMethod.GET)
    public List pageUser(@PathVariable("pageNum")Integer pageNum, @PathVariable("pageSize")Integer pageSize){
        List<User> userList = userService.selectUserPage((pageNum-1)*pageSize, pageSize,"采购员");

        return userList;
    }

    @GetMapping("/getUserTotal")
    @ResponseBody
    public int goodTotal(){
        return userService.getTotal("采购员");
    }


    /**
     * 根据姓名查询该采购员购买过的物资
     * @param name
     * @return
     */
//    @RequiresAuthentication
    @RequestMapping("/findByName/{name}")
    @ResponseBody
    public List<Good> findByName(@Validated @PathVariable("name") String name){
        return userService.findByName(name);

    }

    /**
     * 申请表中还未被处理的个数
     * @return
     */
//    @RequiresAuthentication
    @RequestMapping(value = "/count",method = RequestMethod.GET)
    @ResponseBody
    public String countOrder(String orderStatu){

        return userService.countOrder(orderStatu);
    }


    @RequestMapping(value = "/findNameById",method = RequestMethod.GET)
    @ResponseBody
    public List<GoodOrder> findNameByUserId(String orderStatu){
        return userService.findNameByUserId(orderStatu);

    }

    @RequiresAuthentication
    @GetMapping("/index")
    @ResponseBody
    public Result index(){
        User user = userService.getById(1L);
        return Result.succ(user);

    }

    @PutMapping("/updatePersonal")
    @ResponseBody
    public Result updatePersonal(@RequestBody User user){

        return userService.updatePersonal(user);

    }







}
