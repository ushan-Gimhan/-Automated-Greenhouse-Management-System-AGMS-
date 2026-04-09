package com.agms.automation_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TelemetryRequestDTO {

    private String deviceId;
    private String zoneId;
    private TelemetryData value;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TelemetryData {
        private double temperature;
        private String tempUnit; // e.g., "CELSIUS"
        private double humidity;
        private String humidityUnit; // e.g., "PERCENTAGE"
    }
}
