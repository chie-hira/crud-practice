package com.raisetech.servicepractice.mapper;

import com.raisetech.servicepractice.entity.StoragePlace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StoragePlaceMapper {
//    @Select("SELECT * FROM storage_places")
//    List<StoragePlace> all();

    @Select("SELECT storage_places.*, users.name as user_name, materials.material_name as material_name FROM storage_places JOIN users ON storage_places.user_id = users.id JOIN materials ON storage_places.material_id = materials.id")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "storage_date", column = "storage_date"),
            @Result(property = "storage_place", column = "storage_place"),
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "user_name", column = "user_name"),
            @Result(property = "material_id", column = "material_id"),
            @Result(property = "material_name", column = "material_name")
    })
    List<StoragePlace> all();

}
