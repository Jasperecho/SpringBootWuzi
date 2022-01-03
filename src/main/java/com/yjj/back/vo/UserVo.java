package com.yjj.back.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserVo implements Serializable {

    private String username;
    private String password;
    private String name;
    private String phoneNum;
    private String email;
    private String statu;
    private String city;
    private String live;
    private String perms;


}
