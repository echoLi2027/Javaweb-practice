package com.zzy.mapper;

import com.zzy.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

//    @Select("select * from user")
    public List<User> findAll();

    @Delete("delete from user where id = #{id}")
    public int deleteById(Integer id);

    @Update("update user set username=#{username}, password=#{password}, name=#{name}, age=#{age} where id = #{id}")
    public int updateById(User user);

    @Select("select * from user where username=#{username} and password=#{password}")
    public User findByUsernameAndPassword(@Param("username")String username, @Param("password")String password);


}
