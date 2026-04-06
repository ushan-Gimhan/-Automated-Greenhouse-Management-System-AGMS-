package com.agms.sensor_telemetry_service.repository;

import com.agms.sensor_telemetry_service.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByZoneId(Long zoneId);
}
