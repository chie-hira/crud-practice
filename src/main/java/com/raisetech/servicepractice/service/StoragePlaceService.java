package com.raisetech.servicepractice.service;

import com.raisetech.servicepractice.entity.StoragePlace;
import com.raisetech.servicepractice.exception.MaterialDuplicateException;
import com.raisetech.servicepractice.exception.MaterialNotFoundException;
import com.raisetech.servicepractice.exception.UserNotFoundException;
import com.raisetech.servicepractice.mapper.MaterialMapper;
import com.raisetech.servicepractice.mapper.StoragePlaceMapper;
import com.raisetech.servicepractice.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StoragePlaceService {
    private final StoragePlaceMapper storagePlaceMapper;
    private final UserMapper userMapper;
    private final MaterialMapper materialMapper;

    public StoragePlaceService(StoragePlaceMapper storagePlaceMapper, UserMapper userMapper, MaterialMapper materialMapper){
        this.storagePlaceMapper = storagePlaceMapper;
        this.userMapper = userMapper;
        this.materialMapper = materialMapper;
    }

    public List<StoragePlace> findAll(){
        return this.storagePlaceMapper.findAll();
    }

    public StoragePlace insert(LocalDate storageDate, String storagePlace, int userId, int materialId){
        // userIdがない
        this.userMapper.findById(userId).orElseThrow(() -> new UserNotFoundException("the userId not exists", HttpStatus.BAD_REQUEST));

        // material_idがない
        this.materialMapper.findById(materialId).orElseThrow(()-> new MaterialNotFoundException("the materialId not exists", HttpStatus.BAD_REQUEST));

        // material_idが重複
        Optional<StoragePlace> storagePlaceOptional = this.storagePlaceMapper.findByMaterialId(materialId);
        if (storagePlaceOptional.isPresent()){
            throw new MaterialDuplicateException("the material already stored");
        }

        StoragePlace storagePlaceClass = new StoragePlace(storageDate, storagePlace, userId, materialId);
        storagePlaceMapper.insert(storagePlaceClass);
        return storagePlaceClass;
    }

}
