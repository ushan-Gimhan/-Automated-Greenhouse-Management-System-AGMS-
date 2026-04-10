package com.agms.crop_inventory_service.dto;

@Data
public class CropRequest {
    private String cropName;
    private String batchNumber;
    private Status status; // SEEDLING by default usually
}
