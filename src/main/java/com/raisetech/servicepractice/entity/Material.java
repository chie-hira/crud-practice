package com.raisetech.servicepractice.entity;

public class Material {
    private int id;
    private String materialName;

    public Material(int id, String materialName) {
        this.id = id;
        this.materialName = materialName;
    }

    public Material(String materialName) {
        this.materialName = materialName;
    }


    public int getId() {
        return id;
    }

    public String getMaterialName() {
        return materialName;
    }
}
