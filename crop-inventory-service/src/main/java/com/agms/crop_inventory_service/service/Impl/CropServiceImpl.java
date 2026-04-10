package com.agms.crop_inventory_service.service.Impl;

import com.agms.crop_inventory_service.dto.CropDTO;
import com.agms.crop_inventory_service.dto.CropRequest;
import com.agms.crop_inventory_service.entity.Crop;
import com.agms.crop_inventory_service.entity.Status;
import com.agms.crop_inventory_service.mapper.CropMapper;
import com.agms.crop_inventory_service.repository.CropRepository;
import com.agms.crop_inventory_service.service.CropService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CropServiceImpl implements CropService {

    private final CropRepository cropRepository;

    private final CropMapper cropMapper;
    @Override
    public CropDTO registerBatch(CropDTO request) {
        Crop crop = cropMapper.toEntity(request);
        crop.setStatus(Status.SEEDLING);
        crop.setPlantedAt(LocalDateTime.now());

        Crop savedCrop = cropRepository.save(crop);

        // Return as DTO
        return cropMapper.toDTO(savedCrop);

    }

    @Override
    public List<CropDTO> getAllCrops() {
        return cropRepository.findAll()
                .stream()
                .map(cropMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CropDTO updateStatus(Long id, Status newStatus) {
        // Fetch from DB
        Crop crop = cropRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Crop with ID " + id + " not found"));

        // State Machine Logic (Business Rules)
        Status currentStatus = crop.getStatus();

        if (currentStatus == Status.SEEDLING && newStatus != Status.VEGETATIVE) {
            throw new IllegalStateException("Transition failed: SEEDLING must move to VEGETATIVE.");
        }
        if (currentStatus == Status.VEGETATIVE && newStatus != Status.HARVESTED) {
            throw new IllegalStateException("Transition failed: VEGETATIVE must move to HARVESTED.");
        }
        if (currentStatus == Status.HARVESTED) {
            throw new IllegalStateException("Transition failed: Crop is already HARVESTED.");
        }

        // Update and Save
        crop.setStatus(newStatus);
        Crop updatedCrop = cropRepository.save(crop);

        // Return DTO
        return cropMapper.toDTO(updatedCrop);
    }
}
