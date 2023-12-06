package com.raisetech.servicepractice.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class StoragePlaceRequest {
    @NotNull
    @PastOrPresent(message = "storageDate must be before today")
    private LocalDate storageDate;
    @NotBlank(message = "storagePlace is required")
    private String storagePlace;
    private int userId;
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
