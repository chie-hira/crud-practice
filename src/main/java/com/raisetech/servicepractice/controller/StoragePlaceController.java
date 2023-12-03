package com.raisetech.servicepractice.controller;

import com.raisetech.servicepractice.controller.request.StoragePlaceRequest;
import com.raisetech.servicepractice.controller.response.StoragePlaceResponse;
import com.raisetech.servicepractice.entity.StoragePlace;
import com.raisetech.servicepractice.service.StoragePlaceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class StoragePlaceController {
    private final StoragePlaceService storagePlaceService;

    public StoragePlaceController(StoragePlaceService storagePlaceService){
        this.storagePlaceService = storagePlaceService;
    }

    @GetMapping("/storagePlaces")
    public List<StoragePlace> allStoragePlaces(){
        return this.storagePlaceService.findAll();
    }

    @PostMapping("/storagePlaces")
    public ResponseEntity<StoragePlaceResponse> insert(@RequestBody @Valid StoragePlaceRequest storagePlaceRequest, UriComponentsBuilder uriComponentsBuilder){
        StoragePlace storagePlace = storagePlaceService.insert(storagePlaceRequest.getStorage_date(), storagePlaceRequest.getStorage_place(), storagePlaceRequest.getUser_id(), storagePlaceRequest.getMaterial_id());
        URI location = uriComponentsBuilder.path("/storagePlaces/{id}").buildAndExpand(storagePlace.getId()).toUri();
        StoragePlaceResponse body = new StoragePlaceResponse("storagePlace created");
        return ResponseEntity.created(location).body(body);
    }
}
