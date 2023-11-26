package com.raisetech.servicepractice.mapper;

import com.raisetech.servicepractice.entity.Material;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MaterialMapper {
    @Select("SELECT * FROM materials")
    List<Material> all();

    @Select("SELECT * FROM materials WHERE id = #{id}")
    Optional<Material> byId(int id);
}
