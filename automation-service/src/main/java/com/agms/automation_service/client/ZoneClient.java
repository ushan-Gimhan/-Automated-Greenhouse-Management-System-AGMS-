package com.agms.automation_service.client;

import com.agms.automation_service.dto.ZoneResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "zone-service")
public interface ZoneClient {
    // Fetches thresholds (minTemp, maxTemp) from Port 8081
    @GetMapping("/api/zones/{id}")
    ZoneResponseDTO getZoneThresholds(@PathVariable("id") String id);
}