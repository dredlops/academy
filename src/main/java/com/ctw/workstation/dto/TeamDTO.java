package com.ctw.workstation.dto;

import com.ctw.workstation.entity.Rack;
import com.ctw.workstation.entity.TeamMember;

import java.time.LocalDateTime;
import java.util.List;

public record TeamDTO(int id,
                      List<TeamMemberDTO> teamMembers,
                      List<RackDTO> racks,
                      String name,
                      String product){}
