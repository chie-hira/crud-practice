package com.raisetech.servicepractice.service;

import com.raisetech.servicepractice.entity.Material;
import com.raisetech.servicepractice.entity.StoragePlace;
import com.raisetech.servicepractice.entity.User;
import com.raisetech.servicepractice.exception.MaterialDuplicateException;
import com.raisetech.servicepractice.exception.MaterialNotExistsException;
import com.raisetech.servicepractice.exception.UserNotExistsException;
import com.raisetech.servicepractice.mapper.MaterialMapper;
import com.raisetech.servicepractice.mapper.StoragePlaceMapper;
import com.raisetech.servicepractice.mapper.UserMapper;
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

    public StoragePlace insert(LocalDate storage_date, String storage_place, int user_id, int material_id){
        Optional<User> userOptional = this.userMapper.findById(user_id);
        // user_idがない
        if (userOptional.isEmpty()){
            throw new UserNotExistsException("the user_id not exists");
        }

        // material_idがない
        Optional<Material> materialOptional = this.materialMapper.findById(material_id);
        if (materialOptional.isEmpty()){
            throw new MaterialNotExistsException("the material_id not exists");
        }

        // material_idが重複
        Optional<StoragePlace> storagePlaceOptional = this.storagePlaceMapper.findByMaterialId(material_id);
        if (storagePlaceOptional.isPresent()){
            throw new MaterialDuplicateException("the material already stored");
        }
        StoragePlace storagePlace = new StoragePlace(storage_date, storage_place, user_id, material_id);
        storagePlaceMapper.insert(storagePlace);
        return storagePlace;
    }

}
