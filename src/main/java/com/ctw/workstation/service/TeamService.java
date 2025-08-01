package com.ctw.workstation.service;

import com.ctw.workstation.dto.TeamCreateRequestDTO;
import com.ctw.workstation.dto.TeamDTO;
import com.ctw.workstation.entity.Team;
import com.ctw.workstation.mapper.TeamMapper;
import com.ctw.workstation.repository.TeamMemberRepository;
import com.ctw.workstation.repository.TeamRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@ApplicationScoped
public class TeamService {

    @Inject
    TeamRepository teamRepository;

    @Inject
    TeamMapper teamMapper;

    @Transactional
    public Response createTeam(TeamCreateRequestDTO dto) {
       Team team = teamMapper.toEntity(dto);
       teamRepository.persist(team);
       return Response.ok().entity(teamMapper.toDto(team)).build();
    }

    public Response getAllTeams(){
        if(teamRepository.count()==0)
            return Response.status(Response.Status.NOT_FOUND).entity("Não existem teams na DB.").build();
        return Response.ok().entity(teamRepository.findAll().stream().map(teamMapper::toDto).collect(Collectors.toList())).build();
    }

    public Response getTeamById(int id) {
        if(teamRepository.findByIdOptional(id).isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("Team with ID "+id+" not found.").build();
        return Response.ok().entity(teamMapper.toDto(teamRepository.findById(id))).build();
    }

    public Response deleteTeam(int id) {
        if(teamRepository.findByIdOptional(id).isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("Team with ID "+id+" not found.").build();
        teamRepository.delete(teamRepository.findById(id));
        return Response.ok().entity(true).build();
    }

    public Response updateTeam(TeamCreateRequestDTO dto, int id) {
        Optional<Team> optionalTeam = teamRepository.findByIdOptional(id);
        if(optionalTeam.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("Team with ID "+id+" not found.").build();
        Team team = optionalTeam.get();
        team.defaultLocation=dto.defaultLocation();
        team.product=dto.product();
        team.modifiedAt= LocalDateTime.now();
        teamRepository.persist(team);
        return Response.ok().entity(teamMapper.toDto(team)).build();
    }
}
