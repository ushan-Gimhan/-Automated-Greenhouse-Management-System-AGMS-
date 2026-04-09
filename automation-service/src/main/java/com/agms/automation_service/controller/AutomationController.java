package com.agms.automation_service.controller;

import com.agms.automation_service.dto.TelemetryRequestDTO;
import com.agms.automation_service.entity.AutomationLog;
import com.agms.automation_service.service.AutomationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/automation")
@RequiredArgsConstructor

public class AutomationController {

    private final AutomationService automationService;

    // Internal Endpoint called by Sensor Telemetry Service
    @PostMapping("/process")
    public ResponseEntity<String> processTelemetry(@RequestBody TelemetryRequestDTO request) {
        automationService.evaluateAndTrigger(request);
        return ResponseEntity.ok("Processed successfully");
    }

    // External Endpoint for Farmers
    @GetMapping("/logs")
    public ResponseEntity<List<AutomationLog>> getLogs() {
        return ResponseEntity.ok(automationService.getAllLogs());
    }
}
