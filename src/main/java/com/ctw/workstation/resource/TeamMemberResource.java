package com.ctw.workstation.resource;

import com.ctw.workstation.dto.*;
import com.ctw.workstation.service.TeamMemberService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/team_members")
public class TeamMemberResource {
    @Inject
    Logger log;

    @Inject
    TeamMemberService teamMemberService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TeamMemberDTO> getAllTeamMembers() {
        log.info("getAllMembers");
        return (List<TeamMemberDTO>) teamMemberService.getAllTeamMembers().getEntity();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTeam(TeamMemberCreateRequestDTO teamMember) {
        return Response.status(Response.Status.CREATED).entity(teamMemberService.createTeamMember(teamMember)).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteTeamById(@PathParam("id") int id) {
        if(teamMemberService.getTeamMemberById(id)!=null) {
            log.infov("Deleting teamMember with ID={0}",id);
            teamMemberService.deleteTeamMember(id);
            return Response.status(Response.Status.ACCEPTED).build();
        } else return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/{id}")
    public Response getTeamMemberById(@PathParam("id") int id) {
        if(teamMemberService.getTeamMemberById(id)==null) {
            log.infov("TeamMember not found with ID={0}",id);
            return Response.status(Response.Status.NOT_FOUND).build();
        } else{
            log.infov("Getting teamMember with ID={0}", id);
            return Response.status(Response.Status.OK).entity(teamMemberService.getTeamMemberById(id)).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateTeamMember(@PathParam("id") int id, TeamMemberCreateRequestDTO dto) {

        TeamMemberDTO teamMember = (TeamMemberDTO) teamMemberService.updateTeamMember(dto,id).getEntity();
        log.infov("Updating teamMember with ID={0}.", id);
        return Response.status(Response.Status.ACCEPTED).entity(teamMember).build();
    }
}
