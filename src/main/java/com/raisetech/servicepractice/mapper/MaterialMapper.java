package com.raisetech.servicepractice.mapper;

import com.raisetech.servicepractice.entity.Material;
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
    Optional<Material> findById(int id);

    @Select("SELECT * FROM materials WHERE material_name = #{materialName}")
    Optional<Material> findByName(String materialName);

    @Insert("INSERT INTO materials (material_name) VALUES (#{materialName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Material material);
}
