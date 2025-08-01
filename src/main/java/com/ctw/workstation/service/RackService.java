package com.ctw.workstation.service;

import com.ctw.workstation.dto.RackCreateRequestDTO;
import com.ctw.workstation.entity.Rack;
import com.ctw.workstation.mapper.RackMapper;
import com.ctw.workstation.repository.RackRepository;
import com.ctw.workstation.repository.TeamRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class RackService {

    @Inject
    RackRepository rackRepository;

    @Inject
    RackMapper rackMapper;
    @Inject
    TeamRepository teamRepository;


    @Transactional
    public Response createRack(RackCreateRequestDTO dto) {
        if(teamRepository.findByIdOptional(dto.team_id()).isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("Equipa com id "+dto.team_id()+" not found.").build();
        Rack rack = rackMapper.toEntity(dto);
        rackRepository.persist(rack);
        return Response.status(Response.Status.CREATED).entity(rackMapper.toDto(rack)).build();
    }

    public Response getAllRacks(){
        if(rackRepository.count()==0)
            return Response.status(Response.Status.BAD_REQUEST).entity("Não existem racks na DB.").build();
       return Response.status(Response.Status.OK).entity(rackRepository.findAll().stream().map(rackMapper::toDto).collect(Collectors.toList())).build();
    }

    public Response getRackById(int id){
        if(rackRepository.findByIdOptional(id).isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("Rack com ID "+id+" not found.").build();
        return Response.ok().entity(rackMapper.toDto(rackRepository.findById(id))).build();

    }


    public Response deleteRack(int id){
        if(rackRepository.findByIdOptional(id).isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("Rack com ID "+id+" not found.").build();
        rackRepository.deleteById(id);
        return Response.status(Response.Status.OK).entity(true).build();
    }

    public Response updateRack(RackCreateRequestDTO dto, int id){
        Optional<Rack> opt = rackRepository.findByIdOptional(id);
        if(opt.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("Rack com ID "+id+" not found.").build();
        Rack rack = opt.get();
        rack.assembledAt = dto.assembledAt();
        rack.default_location = dto.default_location();
        rack.serialNumber= dto.serialNumber();
        rack.team = teamRepository.findById(dto.team_id());
        rack.status = dto.status();
        rack.modified_at= LocalDateTime.now();
        rackRepository.persist(rack);
        return Response.ok().entity(rackMapper.toDto(rack)).build();
    }

    public Response getBookingsOfRack(int id){
        return Response.ok().entity(rackRepository.findByIdOptional(id).get().bookings).build();
    }
}
