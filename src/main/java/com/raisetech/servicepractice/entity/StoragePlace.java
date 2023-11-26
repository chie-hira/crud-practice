package com.raisetech.servicepractice.entity;

import java.time.LocalDate;

public class StoragePlace {
    private int id;
    private LocalDate storage_date;
    private int user_id;
    private int material_id;
    private User user;

    public StoragePlace(int id, LocalDate storage_date, int user_id, int material_id) {
        this.id = id;
        this.storage_date = storage_date;
        this.user_id = user_id;
        this.material_id = material_id;
    }

    public int getId() {
        return id;
    }

    public LocalDate getStorage_date() {
        return storage_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getMaterial_id() {
        return material_id;
    }
}
