package com.agms.sensor_telemetry_service.mapper;

import com.agms.sensor_telemetry_service.dto.SensorDto;
import com.agms.sensor_telemetry_service.entity.Sensor;
import org.springframework.stereotype.Component;

@Component
public class SensorMapper {
    // Entity -> DTO
    public SensorDto toDto(Sensor sensor) {
        if (sensor == null) return null;
        return new SensorDto(
                sensor.getId(),
                sensor.getName(),
                sensor.getType(),
                sensor.getStatus(),
                sensor.getZoneId()
        );
    }

    // DTO -> Entity
    public Sensor toEntity(SensorDto dto) {
        if (dto == null) return null;
        Sensor sensor = new Sensor();
        sensor.setId(dto.getId());
        sensor.setName(dto.getName());
        sensor.setType(dto.getType());
        sensor.setStatus(dto.getStatus());
        sensor.setZoneId(dto.getZoneId());
        return sensor;
    }
}
