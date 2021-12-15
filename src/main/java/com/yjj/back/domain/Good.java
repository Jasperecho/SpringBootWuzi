package com.yjj.back.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Good {
    @Id
    private int id;
    private String goodId;
    private String goodName;
    private String goodType;
    private String name;
    private double goodValue;
    private int goodNum;

}
