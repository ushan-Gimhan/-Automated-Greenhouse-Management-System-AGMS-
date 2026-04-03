package com.agms.zone_service.service;

import com.agms.zone_service.dto.ZoneRequestDTO;
import com.agms.zone_service.dto.ZoneResponseDTO;

import java.util.List;

public interface ZoneService {
    ZoneResponseDTO createZone(ZoneRequestDTO request);

    List<ZoneResponseDTO> getAllZones();

    ZoneResponseDTO getZoneById(Long id);
}
