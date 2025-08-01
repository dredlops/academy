package com.ctw.workstation.mapper;

import com.ctw.workstation.dto.TeamCreateRequestDTO;
import com.ctw.workstation.dto.TeamDTO;
import com.ctw.workstation.entity.Team;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface TeamMapper {
    Team toEntity(TeamCreateRequestDTO dto);
    TeamDTO toDto(Team entity);
    List<TeamDTO> toDtos(List<Team> teams);
}
