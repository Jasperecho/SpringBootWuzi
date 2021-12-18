package com.yjj.back.mapper;

import com.yjj.back.domain.GoodOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface BuyerMapper {


    @Select("SELECT * FROM goodorder where userId=#{userId}")
    List<GoodOrder> orderInfoById(@Param("userId")Long userId);


    @Update("update goodorder set orderStatu=#{orderStatu} where id=#{id}")
    void commitAgain(@Param("id")Integer id,String orderStatu);

    @Insert("insert into goodorder(id,orderName,orderNum,orderStatu,userId) values(#{id},#{orderName},#{orderNum},#{orderStatu},#{userId})")
    void applyOrder(GoodOrder goodOrder);
}
