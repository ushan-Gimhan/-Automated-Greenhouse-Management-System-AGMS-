package com.agms.automation_service.rule;

import com.agms.automation_service.dto.ZoneResponseDTO;

public interface AutomationRule {
    boolean shouldTrigger(double value, ZoneResponseDTO thresholds);
    String getActionName();
}
