package com.yjj.back.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;


@Data
public class User implements Serializable {
    @Id
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phoneNum;
    private String email;
    private String statu;
    private String city;
    private String live;
    private String perms;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date date;

}
