package com.raisetech.servicepractice.service;

import com.raisetech.servicepractice.entity.Material;
import com.raisetech.servicepractice.exception.MaterialNotFoundException;
import com.raisetech.servicepractice.mapper.MaterialMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {
    private final MaterialMapper materialMapper;

    public MaterialService(MaterialMapper materialMapper){
        this.materialMapper = materialMapper;
    }

    public List<Material> all(){
        return this.materialMapper.all();
    }

    public Optional<Material> byId(int id){
        Optional<Material> material = this.materialMapper.byId(id);
        if (material.isPresent()){
            return Optional.of(material.get());
        } else {
            throw new MaterialNotFoundException("material not found");
        }
    }
}
