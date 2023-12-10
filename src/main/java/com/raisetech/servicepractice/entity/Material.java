package com.raisetech.servicepractice.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return id == material.id && Objects.equals(materialName, material.materialName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, materialName);
    }
}
