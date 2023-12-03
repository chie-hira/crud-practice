package com.raisetech.servicepractice.controller.request;

import jakarta.validation.constraints.NotNull;

public class MaterialRequest {
   @NotNull
    private String materialName;

   public MaterialRequest(){}

    public MaterialRequest(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialName() {
        return materialName;
    }
}
