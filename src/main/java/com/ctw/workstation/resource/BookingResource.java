package com.ctw.workstation.resource;

import com.ctw.workstation.dto.BookingCreateRequestDTO;
import com.ctw.workstation.dto.BookingDTO;
import com.ctw.workstation.service.BookingService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;


@Path("/bookings")
public class BookingResource {

    @Inject
    BookingService bookingService;

    @Inject
    Logger log;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookingDTO> getAllBookings() {
        log.info("Getting all bookings");
        return (List<BookingDTO>) bookingService.getAllBookings().getEntity();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createBooking(BookingCreateRequestDTO booking) {

        return bookingService.createBooking(booking);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteBookingById(@PathParam("id") int id) {
        if ((boolean) bookingService.deleteBooking(id).getEntity()) {
            log.infov("Deleted booking with ID={0}.", id);
            return Response.status(Response.Status.ACCEPTED).build();
        } else {
            log.infov("Booking with ID={0} not found.", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getBookingById(@PathParam("id") int id) {
        Response dto = bookingService.getBookingById(id);
        log.infov("Getting booking with ID={0}.", id);
        return Response.status(Response.Status.ACCEPTED).entity(dto.getEntity()).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateBooking(@PathParam("id") int id, BookingCreateRequestDTO dto) {
        log.infov("Updating booking with ID={0}.", id);
        BookingDTO booking = (BookingDTO) bookingService.updateBooking(id, dto).getEntity();
        return Response.status(Response.Status.ACCEPTED).entity(booking).build();
    }
}
