package com.raisetech.servicepractice.controller;

import com.raisetech.servicepractice.entity.Material;
import com.raisetech.servicepractice.exception.MaterialNotFoundException;
import com.raisetech.servicepractice.service.MaterialService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
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

    @GetMapping("/materials/{id}")
    public Optional<Material> materialById(@PathVariable("id") int id){
        return  materialService.byId(id);
    }

    @ExceptionHandler(value = MaterialNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleMaterialNotFoundException(
            MaterialNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
