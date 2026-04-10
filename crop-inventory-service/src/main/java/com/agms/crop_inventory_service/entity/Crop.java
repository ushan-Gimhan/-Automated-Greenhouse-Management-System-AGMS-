package com.agms.crop_inventory_service.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cropName;
    private String batchNumber;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime plantedAt;
}
