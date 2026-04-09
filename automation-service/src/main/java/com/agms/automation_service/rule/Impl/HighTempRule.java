package com.agms.automation_service.rule.Impl;


import com.agms.automation_service.dto.ZoneResponseDTO;
import com.agms.automation_service.rule.AutomationRule;
import org.springframework.stereotype.Component;

@Component
public class HighTempRule implements AutomationRule {
    @Override
    public boolean shouldTrigger(double temp, ZoneResponseDTO thresholds) {
        return temp > thresholds.getMaxTemp();
    }
    @Override
    public String getActionName() { return "TURN_FAN_ON"; }
}
