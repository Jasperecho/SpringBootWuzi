package com.yjj.back.mapper;

import com.yjj.back.vo.UserVo;
import org.apache.ibatis.annotations.*;
import com.yjj.back.domain.Good;
import com.yjj.back.domain.GoodOrder;
import com.yjj.back.domain.User;

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


    @Select("select * from user where statu=#{statu} limit #{pageNum},#{pageSize}")
    List<User> selectUserPage(@Param("pageNum")Integer pageNum,
                          @Param("pageSize")Integer pageSize,
                              String statu);


    //查询身份是采购员的姓名
    @Select("select name from user where statu=#{statu}")
    List<User> findName(String statu);

    //查询采购员的物资通过name
    @Select(" select * from good where name=#{name}")
    List<Good> findByName(String name);

    //查询未处理的申请个数
    @Select(" select count(*) from goodorder where orderStatu=#{orderStatu}")
    String countOrder(String orderStatu);

    //查询申请表
    @Select("select * from goodorder left JOIN (SELECT id ,name,phoneNum,email from user)u1 " +
            "ON goodorder.userId = u1.id where orderStatu=#{orderStatu}")
    List<GoodOrder> findNameByUserId(String orderStatu);

    //审批申请修改操作
    @Update("UPDATE goodorder set orderStatu=#{orderStatu} where id=#{id}")
    void updateOrder(@Param("id")Integer id,@Param("orderStatu")String orderStatu);

    @Select("select * from goodorder left JOIN (SELECT id ,name,phoneNum,email from user)u1 " +
            "ON goodorder.userId = u1.id where goodorder.create_time >= '#{date1}' and goodorder.create_time <= '#{date2}'")
    List<GoodOrder> orderScreen(@Param("date1") Date date1,@Param("date2") Date date2);


    @Select("select * from user where id=#{id}")
    User getById(Long id);

    @Select("select count(*) from user where statu=#{statu}")
    int getTotal(String statu);

    @Update("update user set id=#{id},username=#{username},password=#{password}," +
            "name=#{name},city=#{city},phoneNum=#{phoneNum},email=#{email},live=#{live} where id=#{id}")
    void updatePersonal( User user);

    @Select("select phoneNum from user")
    List<String> findAllPhoneNum();

    @Insert("insert into user(username,password,name,phoneNum,email,statu,city,live,perms) " +
            "values(#{username},#{password},#{name},#{phoneNum},#{email},#{statu}," +
            "#{city},#{live},#{perms})")
    int addBuyer(UserVo userVo);
}
