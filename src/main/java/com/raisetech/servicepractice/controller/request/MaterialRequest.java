package com.raisetech.servicepractice.controller.request;

import jakarta.validation.constraints.NotBlank;

public class MaterialRequest {
   @NotBlank(message = "materialName is required")
    private String materialName;

   public MaterialRequest(){}

    public MaterialRequest(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialName() {
        return materialName;
    }
}
