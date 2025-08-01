package com.ctw.workstation.mapper;

import com.ctw.workstation.dto.RackDTO;
import com.ctw.workstation.dto.TeamCreateRequestDTO;
import com.ctw.workstation.dto.TeamDTO;
import com.ctw.workstation.dto.TeamMemberDTO;
import com.ctw.workstation.entity.Team;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-01T11:25:59+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Azul Systems, Inc.)"
)
@ApplicationScoped
public class TeamMapperImpl implements TeamMapper {

    @Override
    public Team toEntity(TeamCreateRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Team team = new Team();

        team.product = dto.product();
        team.defaultLocation = dto.defaultLocation();
        team.createdAt = dto.createdAt();
        team.modifiedAt = dto.modifiedAt();

        return team;
    }

    @Override
    public TeamDTO toDto(Team entity) {
        if ( entity == null ) {
            return null;
        }

        String product = null;

        product = entity.product;

        int id = 0;
        List<TeamMemberDTO> teamMembers = null;
        List<RackDTO> racks = null;
        String name = null;

        TeamDTO teamDTO = new TeamDTO( id, teamMembers, racks, name, product );

        return teamDTO;
    }

    @Override
    public List<TeamDTO> toDtos(List<Team> teams) {
        if ( teams == null ) {
            return null;
        }

        List<TeamDTO> list = new ArrayList<TeamDTO>( teams.size() );
        for ( Team team : teams ) {
            list.add( toDto( team ) );
        }

        return list;
    }
}
