package com.yjj.back.mapper;

import com.yjj.back.domain.GoodOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface BuyerMapper {


    @Select("SELECT * FROM goodorder where userId=#{userId}")
    List<GoodOrder> orderInfoById(@Param("userId")Long userId);
}
