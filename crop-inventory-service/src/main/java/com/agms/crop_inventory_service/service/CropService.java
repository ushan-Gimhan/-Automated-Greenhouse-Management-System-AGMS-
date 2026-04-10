package com.agms.crop_inventory_service.service;

import com.agms.crop_inventory_service.dto.CropDTO;
import com.agms.crop_inventory_service.dto.CropRequest;
import com.agms.crop_inventory_service.entity.Crop;
import com.agms.crop_inventory_service.entity.Status;

import java.util.List;


public interface CropService {
    public CropDTO registerBatch(CropDTO request);
    public List<CropDTO> getAllCrops();
    public CropDTO updateStatus(Long id, Status newStatus);
}
