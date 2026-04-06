package com.agms.sensor_telemetry_service.service.Impl;

import com.agms.sensor_telemetry_service.dto.SensorDto;
import com.agms.sensor_telemetry_service.entity.Sensor;
import com.agms.sensor_telemetry_service.mapper.SensorMapper;
import com.agms.sensor_telemetry_service.repository.SensorRepository;
import com.agms.sensor_telemetry_service.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorServiceImpl implements SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private SensorMapper sensorMapper;

    @Override
    public SensorDto addSensor(SensorDto sensorDto) {
        Sensor sensor = sensorMapper.toEntity(sensorDto);
        Sensor savedSensor = sensorRepository.save(sensor);
        return sensorMapper.toDto(savedSensor);
    }

    @Override
    public List<SensorDto> getSensorsByZone(Long zoneId) {
        return sensorRepository.findByZoneId(zoneId)
                .stream()
                .map(sensorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SensorDto> getAllSensors() {
        return sensorRepository.findAll()
                .stream()
                .map(sensorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSensor(Long id) {
        sensorRepository.deleteById(id);
    }
}
