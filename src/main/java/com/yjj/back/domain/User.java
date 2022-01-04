package com.yjj.back.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@Data
@ExcelTarget("users")
public class User implements Serializable {
    @Id
    @Excel(name = "编号")
    private Long id;

    @Excel(name = "用户名")
    private String username;

    @Excel(name = "密码")
    private String password;

    @Excel(name = "姓名")
    private String name;

    @Excel(name = "手机号",width = 15.0)
    private String phoneNum;

    @Excel(name = "邮箱",width = 24.0)
    private String email;

    @Excel(name = "身份")
    private String statu;

    @Excel(name = "城市")
    private String city;

    @Excel(name = "居住地",width = 24.0)
    private String live;

    @Excel(name = "权限")
    private String perms;

    @Excel(name = "入职日期",exportFormat = "yyyy-MM-dd HH:mm:ss",width = 24.0)
    @JsonFormat(pattern ="yyyy-MM-dd", timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;

}
