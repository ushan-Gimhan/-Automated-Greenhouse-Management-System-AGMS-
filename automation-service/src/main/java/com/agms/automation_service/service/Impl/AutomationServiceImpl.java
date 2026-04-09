package com.agms.automation_service.service.Impl;

import com.agms.automation_service.client.ZoneClient;
import com.agms.automation_service.dto.TelemetryRequestDTO;
import com.agms.automation_service.dto.ZoneResponseDTO;
import com.agms.automation_service.entity.AutomationLog;
import com.agms.automation_service.repository.AutomationLogRepository;
import com.agms.automation_service.rule.AutomationRule;
import com.agms.automation_service.service.AutomationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutomationServiceImpl implements AutomationService {

    private final ZoneClient zoneClient;

    private final AutomationLogRepository logRepository;

    private final List<AutomationRule> rules;

    @Override
    public void evaluateAndTrigger(TelemetryRequestDTO telemetry) {
        ZoneResponseDTO zone = zoneClient.getZoneThresholds(telemetry.getZoneId());

        // 2. Evaluate all active rules (Strategy Pattern)
        if (zone != null && telemetry.getValue() != null) {
            for (AutomationRule rule : rules) {
                // check telemetry.getValue().getTemperature()
                if (rule.shouldTrigger(telemetry.getValue().getTemperature(), zone)) {
                    saveLog(telemetry.getZoneId(), rule.getActionName(), telemetry.getValue().getTemperature());
                }
            }
        }
    }

    private void saveLog(String zoneId, String action, double value) {
        AutomationLog log = new AutomationLog();
        log.setZoneId(zoneId);
        log.setAction(action);
        log.setTriggeredValue(value);
        logRepository.save(log);
    }

    @Override
    public List<AutomationLog> getAllLogs() {
        return logRepository.findAll();
    }
}
