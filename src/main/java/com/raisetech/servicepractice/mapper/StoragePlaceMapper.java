package com.raisetech.servicepractice.mapper;

import com.raisetech.servicepractice.entity.StoragePlace;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StoragePlaceMapper {
    @Select("SELECT storage_places.*, users.name as user_name, materials.material_name as material_name FROM storage_places JOIN users ON storage_places.user_id = users.id JOIN materials ON storage_places.material_id = materials.id")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "storageDate", column = "storage_date"),
            @Result(property = "storagePlace", column = "storage_place"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "materialId", column = "material_id"),
            @Result(property = "materialName", column = "material_name")
    })
    List<StoragePlace> findAll();

    @Select("SELECT * FROM storage_places WHERE material_id = #{materialId}")
    Optional<StoragePlace> findByMaterialId(int materialId);

    @Insert("INSERT INTO storage_places (storage_date, storage_place, user_id, material_id) VALUES (#{storageDate}, #{storagePlace}, #{userId}, #{materialId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(StoragePlace storagePlace);

}
