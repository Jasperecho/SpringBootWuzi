package com.yjj.back.domain;

import lombok.Data;

@Data
public class PageInfo {

    private int pageNum;
    private int pageSize;
    private int total;
}
