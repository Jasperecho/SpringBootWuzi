package com.yjj.back.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class GoodOrder {

    @Id
    private int id;
    private String orderName;
    private String orderNum;
    private String orderStatu;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    private Long userId;

    //采购员姓名,邮箱,手机号
    private String name;
    private String email;
    private String phoneNum;

}
