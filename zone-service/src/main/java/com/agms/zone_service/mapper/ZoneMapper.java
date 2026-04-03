package com.agms.zone_service.mapper;

import com.agms.zone_service.dto.ZoneRequestDTO;
import com.agms.zone_service.dto.ZoneResponseDTO;
import com.agms.zone_service.entity.Zone;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ZoneMapper {

    private ModelMapper modelMapper;

    // Entity -> ResponseDTO
    public ZoneResponseDTO toResponseDTO(Zone zone) {
        return modelMapper.map(zone, ZoneResponseDTO.class);
    }

    // RequestDTO -> Entity
    public Zone toEntity(ZoneRequestDTO dto) {
        return modelMapper.map(dto, Zone.class);
    }
}
