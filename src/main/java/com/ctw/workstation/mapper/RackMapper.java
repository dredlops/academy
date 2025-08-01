package com.ctw.workstation.mapper;

import com.ctw.workstation.dto.RackCreateRequestDTO;
import com.ctw.workstation.dto.RackDTO;
import com.ctw.workstation.entity.Rack;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface RackMapper {
    Rack toEntity(RackCreateRequestDTO dto);
    RackDTO toDto(Rack entity);
    List<RackDTO> toDtos(List<Rack> racks);
}
