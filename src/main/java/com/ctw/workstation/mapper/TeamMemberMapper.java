package com.ctw.workstation.mapper;

import com.ctw.workstation.dto.TeamMemberCreateRequestDTO;
import com.ctw.workstation.dto.TeamMemberDTO;
import com.ctw.workstation.entity.TeamMember;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "cdi")
public interface TeamMemberMapper {
    TeamMember toEntity(TeamMemberCreateRequestDTO dto);
    TeamMemberDTO toDto(TeamMember entity);
    List<TeamMemberDTO> toDtos(List<TeamMember> teamMembers);
}
