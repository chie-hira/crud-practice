package com.raisetech.servicepractice.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MaterialRequest {
   @NotNull
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
