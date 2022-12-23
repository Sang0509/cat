package com.cat.cat.mapper;


import com.cat.cat.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    //全件
    @Select("select * from user")
    List<User> findAll();

    //新規
    @Insert("INSERT INTO `user` (`userid`, `name`, `address`, `cost`) VALUES ( #{userid}, #{name}, #{address}, #{cost})")
    int insert(User user);
    //更新
    int update(User user);

    //削除
    @Delete("delete from user where id = #{id}")
    Integer deleteById(@Param("id") Integer id);

    //Mysql进行分页查询
    @Select("select * from user limit #{pageNum},#{pageSize}")
    List<User> selectPage(Integer pageNum,Integer pageSize);

    @Select("select count(*) from user")
    int findCount();
}
