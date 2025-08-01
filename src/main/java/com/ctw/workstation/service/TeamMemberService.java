package com.ctw.workstation.service;

import com.ctw.workstation.dto.TeamMemberCreateRequestDTO;
import com.ctw.workstation.dto.TeamMemberDTO;
import com.ctw.workstation.entity.TeamMember;
import com.ctw.workstation.mapper.TeamMemberMapper;
import com.ctw.workstation.repository.TeamMemberRepository;
import com.ctw.workstation.repository.TeamRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TeamMemberService {

    @Inject
    TeamMemberRepository teamMemberRepository;

    @Inject
    TeamMemberMapper teamMemberMapper;
    @Inject
    TeamRepository teamRepository;

    public static void main(String[] args) {

    }

    @Transactional
    public Response createTeamMember(TeamMemberCreateRequestDTO dto){
        if(teamRepository.findByIdOptional(dto.team_id()).isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("Team id not found.").build();
        TeamMember entity = teamMemberMapper.toEntity(dto);
        teamMemberRepository.persist(entity);
        return Response.ok().entity(teamMemberMapper.toDto(entity)).build();
    }

    public Response getAllTeamMembers(){
        if(teamMemberRepository.count()==0)
            return Response.status(Response.Status.BAD_REQUEST).entity("Não existem TeamMembers na DB.").build();
        List<TeamMember> members = teamMemberRepository.findAll().stream().toList();
        return Response.ok().entity(members.stream().map(teamMemberMapper::toDto).collect(Collectors.toList())).build();
    }

    @Transactional
    public Response getTeamMemberById(int id){
        if(teamMemberRepository.findByIdOptional(id).isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("TeamMember id not found.").build();
        return Response.ok().entity(teamMemberMapper.toDto(teamMemberRepository.findById(id))).build();
    }

    @Transactional
    public Response deleteTeamMember(int id){
        if(teamMemberRepository.findByIdOptional(id).isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("TeamMember id not found.").build();
        teamMemberRepository.delete(teamMemberRepository.findById(id));
        return Response.ok().entity(true).build();
    }

    public Response updateTeamMember(TeamMemberCreateRequestDTO dto, int id){
        if(teamMemberRepository.findByIdOptional(id).isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("TeamMember id not found.").build();
        if(teamRepository.findByIdOptional(dto.team_id()).isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("Team id "+dto.team_id()+" not found.").build();
        TeamMember teamMember = teamMemberRepository.findById(id);
       teamMember.team=teamRepository.findById(dto.team_id());
       teamMember.name=dto.name();
       teamMember.ctw_id=dto.ctw_id();
       teamMember.modified_at= LocalDateTime.now();
       teamMemberRepository.persist(teamMember);
       return Response.ok().entity(teamMemberMapper.toDto(teamMember)).build();
    }


}
