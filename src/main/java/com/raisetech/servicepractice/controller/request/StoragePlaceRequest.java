package com.raisetech.servicepractice.controller.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class StoragePlaceRequest {
    @NotNull
    private LocalDate storage_date;
    @NotNull
    private String storage_place;
    @NotNull
    private int user_id;
    @NotNull
    private int material_id;

    public StoragePlaceRequest(LocalDate storage_date, String storage_place, int user_id, int material_id) {
        this.storage_date = storage_date;
        this.storage_place = storage_place;
        this.user_id = user_id;
        this.material_id = material_id;
    }

    public LocalDate getStorage_date() {
        return storage_date;
    }

    public String getStorage_place() {
        return storage_place;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getMaterial_id() {
        return material_id;
    }
}
