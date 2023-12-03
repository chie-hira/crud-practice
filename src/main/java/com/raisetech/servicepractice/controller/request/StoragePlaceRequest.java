package com.raisetech.servicepractice.controller.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class StoragePlaceRequest {
    @NotNull
    private LocalDate storageDate;
    @NotNull
    private String storagePlace;
    @NotNull
    private int userId;
    @NotNull
    private int materialId;

    public StoragePlaceRequest(LocalDate storageDate, String storagePlace, int userId, int materialId) {
        this.storageDate = storageDate;
        this.storagePlace = storagePlace;
        this.userId = userId;
        this.materialId = materialId;
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

    public int getMaterialId() {
        return materialId;
    }
}
