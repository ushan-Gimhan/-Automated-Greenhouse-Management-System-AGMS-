package com.agms.zone_service.controller;

import com.agms.zone_service.dto.ZoneRequestDTO;
import com.agms.zone_service.dto.ZoneResponseDTO;
import com.agms.zone_service.entity.Zone;
import com.agms.zone_service.service.Impl.ZoneServiceImpl;
import com.agms.zone_service.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zones")
public class ZoneController {

    @Autowired
    private ZoneServiceImpl zoneService;

    @PostMapping
    public ResponseEntity<ZoneResponseDTO> create(@RequestBody ZoneRequestDTO request) {
        return ResponseEntity.ok(zoneService.createZone(request));
    }

    @GetMapping
    public ResponseEntity<List<ZoneResponseDTO>> getAll() {
        return ResponseEntity.ok(zoneService.getAllZones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZoneResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(zoneService.getZoneById(id));
    }
}
