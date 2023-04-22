package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;

public interface UserMapper {

    @Select("select * from users where username = #{name}")
    User selectByUsername(String name);

}
