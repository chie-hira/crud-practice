package com.raisetech.servicepractice.mapper;

import com.raisetech.servicepractice.entity.Material;
import com.raisetech.servicepractice.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MaterialMapper {
    @Select("SELECT * FROM materials")
    List<Material> findAll();

    @Select("SELECT * FROM materials WHERE id = #{id}")
    Optional<Material> byId(int id);

    @Insert("INSERT INTO materials (material_name) VALUES (#{material_name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Material material);
}
