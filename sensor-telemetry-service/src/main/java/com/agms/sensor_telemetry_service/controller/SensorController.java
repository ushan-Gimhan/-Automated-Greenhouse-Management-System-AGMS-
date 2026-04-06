package com.agms.sensor_telemetry_service.controller;

import com.agms.sensor_telemetry_service.dto.SensorDto;
import com.agms.sensor_telemetry_service.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @PostMapping
    public ResponseEntity<SensorDto> createSensor(@RequestBody SensorDto sensorDto) {
        return ResponseEntity.ok(sensorService.addSensor(sensorDto));
    }

    @GetMapping("/zone/{zoneId}")
    public ResponseEntity<List<SensorDto>> getSensorsByZone(@PathVariable Long zoneId) {
        return ResponseEntity.ok(sensorService.getSensorsByZone(zoneId));
    }

    @GetMapping
    public ResponseEntity<List<SensorDto>> getAll() {
        return ResponseEntity.ok(sensorService.getAllSensors());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSensor(@PathVariable Long id) {
        sensorService.deleteSensor(id);
        return ResponseEntity.ok("Sensor deleted successfully!");
    }
}
