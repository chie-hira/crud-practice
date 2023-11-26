package com.raisetech.servicepractice.controller;

import com.raisetech.servicepractice.entity.StoragePlace;
import com.raisetech.servicepractice.service.StoragePlaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoragePlaceController {
    private final StoragePlaceService storagePlaceService;

    public StoragePlaceController(StoragePlaceService storagePlaceService){
        this.storagePlaceService = storagePlaceService;
    }

    @GetMapping("/storagePlaces")
    public List<StoragePlace> allStoragePlaces(){
        return this.storagePlaceService.all();
    }
}
