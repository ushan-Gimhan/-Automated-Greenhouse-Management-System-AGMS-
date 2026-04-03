package com.agms.zone_service.service.Impl;

import com.agms.zone_service.client.ExternalIotClient;
import com.agms.zone_service.dto.ZoneRequestDTO;
import com.agms.zone_service.dto.ZoneResponseDTO;
import com.agms.zone_service.entity.Zone;
import com.agms.zone_service.mapper.ZoneMapper;
import com.agms.zone_service.repository.ZoneRepository;
import com.agms.zone_service.service.ZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ZoneServiceImpl implements ZoneService {

    private final ZoneRepository zoneRepository;
    private final ZoneMapper zoneMapper;
    private final ExternalIotClient iotClient;

    @Override
    public ZoneResponseDTO createZone(ZoneRequestDTO request) {
        //Validation (Business Logic)
        if (request.getMinTemp() >= request.getMaxTemp()) {
            throw new RuntimeException("MinTemp must be less than MaxTemp");
        }

        //Map DTO to Entity
        Zone zone = zoneMapper.toEntity(request);

        //External Integration (register device)
        try {
            Map<String, String> creds = Map.of("username", "user", "password", "123456");
            String token = "Bearer " + iotClient.login(creds).get("accessToken");

            Map<String, String> deviceReq = Map.of("name", zone.getName(), "zoneId", zone.getName());
            Map<String, Object> deviceRes = iotClient.registerDevice(token, deviceReq);

            zone.setDeviceId(deviceRes.get("deviceId").toString());
        } catch (Exception e) {
            throw new RuntimeException("Could not connect to External IoT Service: " + e.getMessage());
        }

        // Save and return DTO
        Zone savedZone = zoneRepository.save(zone);
        return zoneMapper.toResponseDTO(savedZone);
    }

    @Override
    public List<ZoneResponseDTO> getAllZones() {
        return zoneRepository.findAll().stream()
                .map(zoneMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ZoneResponseDTO getZoneById(Long id) {
        Zone zone = zoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Zone not found"));
        return zoneMapper.toResponseDTO(zone);
    }
}
