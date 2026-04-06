package com.agms.sensor_telemetry_service.service;

import com.agms.sensor_telemetry_service.dto.SensorDto;

import java.util.List;

public interface SensorService {
    SensorDto addSensor(SensorDto sensorDto);
    List<SensorDto> getSensorsByZone(Long zoneId);
    List<SensorDto> getAllSensors();
    void deleteSensor(Long id);
}
