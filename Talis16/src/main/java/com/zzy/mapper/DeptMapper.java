package com.zzy.mapper;

import com.zzy.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    /*@Results(
            {@Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")}
    )*/
    @Select("select id, name, create_time, update_time from dept")
//    @Select("select id, name, create_time createTime, update_time updateTime from dept")
    List<Dept> findAll();

    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept searchById(Integer id);

    @Update("update dept set name = #{name}, update_time=#{updateTime} where id = #{id}")
    void update(Dept dept);
}
