package com.yjj.back.controller;

import cn.hutool.Hutool;
import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.yjj.back.common.Result;
import com.yjj.back.common.dto.LoginDto;
import com.yjj.back.domain.User;
import com.yjj.back.service.UserService;
import com.yjj.back.utils.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;


    @PostMapping("/login")
    public List<Object> login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {

        User user = userService.findUsernameAndPwd(loginDto.getUsername(), loginDto.getPassword());
        List<Object> results = new ArrayList<>();
        if (user==null){
            return (List<Object>) Result.fail("错误");
        }
        if(!user.getPassword().equals(loginDto.getPassword())){
            return (List<Object>) Result.fail("密码不正确");
        }
        String jwt = jwtUtils.generateToken(user.getId());
        System.out.println(jwt);

        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");
        results.add(jwt);
        results.add(JSONUtil.toJsonStr(user));
        return results;

    }

    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }







}
