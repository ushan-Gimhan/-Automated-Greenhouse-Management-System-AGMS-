package com.agms.crop_inventory_service.mapper;

import com.agms.crop_inventory_service.dto.CropDTO;
import com.agms.crop_inventory_service.entity.Crop;
import com.agms.crop_inventory_service.entity.Status;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CropMapper {
    public CropDTO toDTO(Crop entity) {
        if (entity == null) return null;

        return CropDTO.builder()
                .id(entity.getId())
                .cropName(entity.getCropName())
                .batchNumber(entity.getBatchNumber())
                .status(String.valueOf(entity.getStatus()))
                .plantedAt(String.valueOf(entity.getPlantedAt()))
                .build();
    }

    public Crop toEntity(CropDTO dto) {
        if (dto == null) return null;

        Crop entity = new Crop();
        entity.setId(dto.getId());
        entity.setCropName(dto.getCropName());
        entity.setBatchNumber(dto.getBatchNumber());
        entity.setStatus(Status.valueOf(dto.getStatus()));
        entity.setPlantedAt(LocalDateTime.parse(dto.getPlantedAt()));
        return entity;
    }
}
