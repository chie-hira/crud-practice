package com.raisetech.servicepractice.entity;

public class Material {
    private int id;
    private String material_name;

    public Material(int id, String material_name) {
        this.id = id;
        this.material_name = material_name;
    }

    public Material(String material_name) {
        this.material_name = material_name;
    }


    public int getId() {
        return id;
    }

    public String getMaterial_name() {
        return material_name;
    }
}
