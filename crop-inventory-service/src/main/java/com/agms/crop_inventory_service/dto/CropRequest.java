package com.agms.crop_inventory_service.dto;

import com.agms.crop_inventory_service.entity.Status;
import lombok.Data;

@Data
public class CropRequest {
    private String cropName;
    private String batchNumber;
    private Status status; // SEEDLING by default usually
}
