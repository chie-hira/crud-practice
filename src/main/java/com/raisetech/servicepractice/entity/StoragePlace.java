package com.raisetech.servicepractice.entity;

import java.time.LocalDate;

public class StoragePlace {
    private int id;
    private LocalDate storage_date;
    private String storage_place;
    private int user_id;
    private String user_name;
    private int material_id;
    private String material_name;

    public StoragePlace(int id, LocalDate storage_date, String storage_place, int user_id, int material_id, String user_name, String material_name) {
        this.id = id;
        this.storage_date = storage_date;
        this.storage_place = storage_place;
        this.user_id = user_id;
        this.user_name = user_name;
        this.material_id = material_id;
        this.material_name = material_name;
    }

    public StoragePlace(int id, LocalDate storage_date, String storage_place, int user_id, int material_id) {
        this.id = id;
        this.storage_date = storage_date;
        this.storage_place = storage_place;
        this.user_id = user_id;
        this.material_id = material_id;
    }

    public StoragePlace(LocalDate storage_date, String storage_place, int user_id, int material_id) {
        this.storage_date = storage_date;
        this.storage_place = storage_place;
        this.user_id = user_id;
        this.material_id = material_id;
    }

    public int getId() {
        return id;
    }

    public LocalDate getStorageDate() {
        return storage_date;
    }

    public String getStoragePlace() {
        return storage_place;
    }

    public int getUserId() {
        return user_id;
    }

    public String getUserName() {
        return user_name;
    }

    public int getMaterialId() {
        return material_id;
    }

    public String getMaterialName() {
        return material_name;
    }
}
