package com.raisetech.servicepractice.controller.request;

import jakarta.validation.constraints.NotNull;

public class MaterialRequest {
   @NotNull
    private String material_name;

   public MaterialRequest(){}

    public MaterialRequest(String material_name) {
        this.material_name = material_name;
    }

    public String getMaterial_name() {
        return material_name;
    }
}
