package com.agms.crop_inventory_service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CropDTO {
    private Long id;
    private String cropName;
    private String batchNumber;
    private String status; // String format for JSON
    private String plantedAt;
}
