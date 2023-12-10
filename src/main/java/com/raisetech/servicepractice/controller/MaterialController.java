package com.raisetech.servicepractice.controller;

import com.raisetech.servicepractice.controller.request.MaterialRequest;
import com.raisetech.servicepractice.controller.response.MaterialResponse;
import com.raisetech.servicepractice.entity.Material;
import com.raisetech.servicepractice.service.MaterialService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
        return materialService.findAll();
    }

    @GetMapping("/materials/{id}")
    public Material materialById(@PathVariable("id") int id){
        return  materialService.findById(id);
    }

    @PostMapping("/materials")
    public ResponseEntity<MaterialResponse> insert(@RequestBody @Valid MaterialRequest materialRequest, UriComponentsBuilder uriComponentsBuilder){
        Material material = materialService.insert(materialRequest.getMaterialName());
        URI location = uriComponentsBuilder.path("materials/{id}").buildAndExpand(material.getId()).toUri();
        MaterialResponse body = new MaterialResponse("material created");
        return ResponseEntity.created(location).body(body);
    }

}
