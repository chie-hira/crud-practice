package com.raisetech.servicepractice.mapper;

import com.raisetech.servicepractice.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE id = #{id}")
    Optional<User> findById(int id);
}
