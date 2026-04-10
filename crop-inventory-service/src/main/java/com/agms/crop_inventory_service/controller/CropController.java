package com.agms.crop_inventory_service.controller;

import com.agms.crop_inventory_service.dto.CropDTO;
import com.agms.crop_inventory_service.entity.Status;
import com.agms.crop_inventory_service.service.CropService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
@RequiredArgsConstructor
public class CropController {
    private final CropService cropService;
    @PostMapping
    public ResponseEntity<CropDTO> registerBatch(@RequestBody CropDTO cropDTO) {
        CropDTO createdCrop = cropService.registerBatch(cropDTO);
        return new ResponseEntity<>(createdCrop, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CropDTO>> getAllCrops() {
        return ResponseEntity.ok(cropService.getAllCrops());
    }


    @PutMapping("/{id}/status")
    public ResponseEntity<CropDTO> updateStatus(
            @PathVariable Long id,
            @RequestParam Status status) {

        return ResponseEntity.ok(cropService.updateStatus(id, status));
    }
}
