package com.agms.automation_service.service;

import com.agms.automation_service.dto.ZoneResponseDTO;

import java.util.Optional;

public interface AutomationRuleService {
    Optional<String> evaluate(double currentTemp, ZoneResponseDTO thresholds);
}
