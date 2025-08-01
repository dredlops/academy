package com.ctw.workstation.resource;

import com.ctw.workstation.dto.TeamCreateRequestDTO;
import com.ctw.workstation.dto.TeamDTO;
import com.ctw.workstation.service.TeamService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/teams")
public class TeamResource {

    @Inject
    Logger log;
    @Inject
    TeamService teamService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TeamDTO> getAllTeams() {
        log.info("getAllTeams");
        return (List<TeamDTO>) teamService.getAllTeams().getEntity();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTeam(TeamCreateRequestDTO team) {
        return Response.status(Response.Status.CREATED).entity(teamService.createTeam(team)).build();

    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteTeamById(@PathParam("id") int id) {
        if((boolean) teamService.deleteTeam(id).getEntity()){
            log.infov("Deleted team with ID={0}.", id);
            return Response.status(Response.Status.ACCEPTED).build();
        } else {
            log.infov("Team with ID={0} not found.", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getTeamById(@PathParam("id") int id) {
        TeamDTO dto = (TeamDTO) teamService.getTeamById(id).getEntity();
        log.infov("Getting team with ID={0}", id);
        return Response.status(Response.Status.ACCEPTED).entity(dto).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTeam(@PathParam("id") int id, TeamCreateRequestDTO dto) {

        TeamDTO team = (TeamDTO) teamService.updateTeam(dto,id).getEntity();
        log.infov("Updating team with ID={0}.", id);
        return Response.status(Response.Status.ACCEPTED).entity(team).build();
    }


}
