package com.raisetech.servicepractice.mapper;

import com.raisetech.servicepractice.entity.StoragePlace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StoragePlaceMapper {
    @Select("SELECT * FROM storage_places")
    List<StoragePlace> all();

}
