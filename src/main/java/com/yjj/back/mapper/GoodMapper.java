package com.yjj.back.mapper;

import com.yjj.back.domain.PageInfo;
import org.apache.ibatis.annotations.*;
import com.yjj.back.domain.Good;
import com.yjj.back.domain.GoodOrder;

import java.util.List;

@Mapper
public interface GoodMapper {

    //查全部
    @Select({"select * from good"})
    List<Good> selectGood();

    @Select({"select * from good limit #{pageNum},#{pageSize} "})
    List<Good> selectPage(@Param("pageNum")Integer pageNum,
                            @Param("pageSize")Integer pageSize);



    //添加
    @Insert("  insert into good values (null,#{goodName},#{goodType},#{goodValue},#{goodNum},#{name},#{goodId})")
    void addGood(Good good);

    //根据id 查询物资
    @Select({"select * from good where id=#{id}"})
    Good findById(Integer id);

    //修改物资
    @Update({" update good set id=#{id},goodName=#{goodName},goodType=#{goodType},goodValue=#{goodValue},goodNum=#{goodNum},name=#{name} where id=#{id}"})
    void updateGood(Good good);

    //删除物资
    @Delete({" delete from good where id=#{id}"})
    void deleteGood(@Param("id") Integer id);

    //查询已处理的
    @Select("select * from goodorder left JOIN (SELECT id ,name,phoneNum,email from user)u1 " +
            "ON goodorder.userId = u1.id where orderStatu is not null")
    List<GoodOrder> orderRecord();


    @Select("select count(*) from good")
    int getTotal();
}
