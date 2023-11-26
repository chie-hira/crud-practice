package com.raisetech.servicepractice.controller;

import com.raisetech.servicepractice.entity.Material;
import com.raisetech.servicepractice.service.MaterialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MaterialController {
    private final MaterialService materialService;

    public MaterialController(MaterialService materialService){
        this.materialService = materialService;
    }

    @GetMapping("/materials")
    public List<Material> allMaterials(){
        return materialService.all();
    }
}
