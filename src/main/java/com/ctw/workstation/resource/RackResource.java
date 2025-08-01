package com.ctw.workstation.resource;

import com.ctw.workstation.dto.RackCreateRequestDTO;
import com.ctw.workstation.dto.RackDTO;
import com.ctw.workstation.service.RackService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;



import java.util.List;

@Path("/racks")
public class RackResource {

    @Inject
    RackService rackService;

    @Inject
    Logger log;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RackDTO> getAllRacks() {
        log.info("Getting all racks");
        return (List<RackDTO>) rackService.getAllRacks().getEntity();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRack(RackCreateRequestDTO rackDto) {
        return Response.status(Response.Status.CREATED).entity(rackService.createRack(rackDto)).build();
    }

    @GET
    @Path("/{id}")
    public Response getRackById(@PathParam("id") int id) {
        RackDTO dto = (RackDTO) rackService.getRackById(id).getEntity();
        log.infov("Getting rack with ID={0}.", id);
        return Response.status(Response.Status.ACCEPTED).entity(dto).build();
        }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteRackById(@PathParam("id") int id) {
        if((boolean) rackService.deleteRack(id).getEntity()){
            log.infov("Deleted rack with ID={0}.", id);
            return Response.status(Response.Status.ACCEPTED).build();
        } else {
            log.infov("Rack with ID={0} not found.", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateRack(@PathParam("id") int id, RackCreateRequestDTO dto) {
        RackDTO rack = (RackDTO) rackService.updateRack(dto,id).getEntity();
        log.infov("Updating rack with ID={0}.", id);
        return Response.status(Response.Status.ACCEPTED).entity(rack).build();
    }

    @GET
    @Path("/bookings/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookingByRack(int id) {
        return rackService.getBookingsOfRack(id);
    }
}




