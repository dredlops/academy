package com.ctw.workstation.mapper;

import com.ctw.workstation.dto.TeamMemberCreateRequestDTO;
import com.ctw.workstation.dto.TeamMemberDTO;
import com.ctw.workstation.entity.Booking;
import com.ctw.workstation.entity.TeamMember;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-01T11:25:58+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Azul Systems, Inc.)"
)
@ApplicationScoped
public class TeamMemberMapperImpl implements TeamMemberMapper {

    @Override
    public TeamMember toEntity(TeamMemberCreateRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TeamMember teamMember = new TeamMember();

        teamMember.team_id = dto.team_id();
        teamMember.ctw_id = dto.ctw_id();
        teamMember.name = dto.name();

        return teamMember;
    }

    @Override
    public TeamMemberDTO toDto(TeamMember entity) {
        if ( entity == null ) {
            return null;
        }

        int team_id = 0;
        List<Booking> bookings = null;
        String ctw_id = null;
        String name = null;

        team_id = entity.team_id;
        List<Booking> list = entity.bookings;
        if ( list != null ) {
            bookings = new ArrayList<Booking>( list );
        }
        ctw_id = entity.ctw_id;
        name = entity.name;

        int id = 0;

        TeamMemberDTO teamMemberDTO = new TeamMemberDTO( id, team_id, bookings, ctw_id, name );

        return teamMemberDTO;
    }

    @Override
    public List<TeamMemberDTO> toDtos(List<TeamMember> teamMembers) {
        if ( teamMembers == null ) {
            return null;
        }

        List<TeamMemberDTO> list = new ArrayList<TeamMemberDTO>( teamMembers.size() );
        for ( TeamMember teamMember : teamMembers ) {
            list.add( toDto( teamMember ) );
        }

        return list;
    }
}
