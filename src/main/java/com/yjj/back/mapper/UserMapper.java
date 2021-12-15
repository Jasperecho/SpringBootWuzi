package com.yjj.back.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.yjj.back.domain.Good;
import com.yjj.back.domain.GoodOrder;
import com.yjj.back.domain.User;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();

    //登录
    @Select(" select * from user where username=#{username} and password=#{password}")
    User findUsernameAndPwd(@Param("username") String username,
                            @Param("password") String password
                            );

    //分页查询是采购员
    @Select("select * from user where statu=#{statu}")
    List<User> selectUser(String statu);


    //查询身份是采购员的姓名
    @Select("select name from user where statu=#{statu}")
    List<User> findName(String statu);

    //查询采购员的物资通过name
    @Select(" select * from good where name=#{name}")
    List<Good> findByName(String name);

    //查询未处理的申请个数
    @Select(" select count(*) from goodorder where orderStatu is null ;")
    String countOrder();

    //查询申请表
    @Select("select * from goodorder left JOIN (SELECT id ,name,phoneNum,email from user)u1 " +
            "ON goodorder.userId = u1.id where orderStatu is null")
    List<GoodOrder> findNameByUserId();

    //审批申请修改操作
    @Update("UPDATE goodorder set orderStatu=#{orderStatu} where id=#{id}")
    void updateOrder(@Param("id")Integer id,@Param("orderStatu")String orderStatu);

    @Select("select * from goodorder left JOIN (SELECT id ,name,phoneNum,email from user)u1 " +
            "ON goodorder.userId = u1.id where create_time between #{date1} and #{date2}")
    List<GoodOrder> orderScreen(@Param("date1") Date date1,@Param("date2") Date date2);


    @Select("select * from user where id=#{id}")
    User getById(Long id);
}
