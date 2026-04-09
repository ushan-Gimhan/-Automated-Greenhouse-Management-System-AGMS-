package com.agms.automation_service.service;

import com.agms.automation_service.dto.TelemetryRequestDTO;
import com.agms.automation_service.entity.AutomationLog;

import java.util.List;


public interface AutomationService {
    void evaluateAndTrigger(TelemetryRequestDTO telemetry);
    List<AutomationLog> getAllLogs();
}
