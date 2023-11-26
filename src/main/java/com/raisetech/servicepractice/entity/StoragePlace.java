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

    public int getId() {
        return id;
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

    public String getUser_name() {
        return user_name;
    }

    public int getMaterial_id() {
        return material_id;
    }

    public String getMaterial_name() {
        return material_name;
    }
}
