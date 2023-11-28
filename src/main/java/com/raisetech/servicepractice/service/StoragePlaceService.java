package com.raisetech.servicepractice.service;

import com.raisetech.servicepractice.entity.StoragePlace;
import com.raisetech.servicepractice.mapper.StoragePlaceMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoragePlaceService {
    private final StoragePlaceMapper storagePlaceMapper;

    public StoragePlaceService(StoragePlaceMapper storagePlaceMapper){
        this.storagePlaceMapper = storagePlaceMapper;
    }

    public List<StoragePlace> findAll(){
        return this.storagePlaceMapper.findAll();
    }


}
