package com.agms.sensor_telemetry_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorDto {
    private Long id;
    private String name;
    private String type;
    private String status;
    private Long zoneId;
}
