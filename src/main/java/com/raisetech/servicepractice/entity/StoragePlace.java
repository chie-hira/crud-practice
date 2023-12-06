package com.raisetech.servicepractice.entity;

import java.time.LocalDate;

public class StoragePlace {
    private int id;
    private LocalDate storageDate;
    private String storagePlace;
    private int userId;
    private String userName;
    private int materialId;
    private String materialName;

    public StoragePlace(int id, LocalDate storageDate, String storagePlace, int userId, int materialId, String userName, String materialName) {
        this.id = id;
        this.storageDate = storageDate;
        this.storagePlace = storagePlace;
        this.userId = userId;
        this.userName = userName;
        this.materialId = materialId;
        this.materialName = materialName;
    }

    public StoragePlace(int id, LocalDate storageDate, String storagePlace, int userId, int materialId) {
        this.id = id;
        this.storageDate = storageDate;
        this.storagePlace = storagePlace;
        this.userId = userId;
        this.materialId = materialId;
    }

    public StoragePlace(LocalDate storageDate, String storagePlace, int userId, int materialId) {
        this.storageDate = storageDate;
        this.storagePlace = storagePlace;
        this.userId = userId;
        this.materialId = materialId;
    }

    public int getId() {
        return id;
    }

    public LocalDate getStorageDate() {
        return storageDate;
    }

    public String getStoragePlace() {
        return storagePlace;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getMaterialId() {
        return materialId;
    }

    public String getMaterialName() {
        return materialName;
    }
}
