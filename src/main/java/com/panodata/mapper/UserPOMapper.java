package com.panodata.mapper;

import com.panodata.model.UserPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserPOMapper {

    @Select("select * from user")
    List<UserPO> findAll();

    @Select("select * from user where id = #{id}")
    UserPO findById(String id);

    @Select("select * from user where id = #{id} and name = #{name}")
    UserPO findByIdAndName(@Param("id") String id, @Param("name") String name);

    @Insert("INSERT INTO user (id,name,age,sex,tel) VALUES(#{id}, #{name}, #{age}, #{sex}, #{tel})")
    int insert(UserPO user);

    @Update("UPDATE user SET name=#{name},tel=#{tel} WHERE id =#{id}")
    int updateUserById(@Param("id") String id,@Param("name") String name,@Param("tel") String tel);
}