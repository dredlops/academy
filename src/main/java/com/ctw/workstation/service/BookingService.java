package com.ctw.workstation.service;

import com.ctw.workstation.dto.BookingCreateRequestDTO;
import com.ctw.workstation.entity.Booking;
import com.ctw.workstation.entity.Rack;
import com.ctw.workstation.entity.TeamMember;
import com.ctw.workstation.mapper.BookingMapper;
import com.ctw.workstation.repository.BookingRepository;
import com.ctw.workstation.repository.RackRepository;
import com.ctw.workstation.repository.TeamMemberRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookingService {
    @Inject
    BookingRepository bookingRepository;

    @Inject
    BookingMapper bookingMapper;

    @Inject
    RackRepository rackRepository;
    @Inject
    TeamMemberRepository teamMemberRepository;

    @Transactional
    public Response createBooking(BookingCreateRequestDTO dto) {
        if(rackRepository.findByIdOptional(dto.rack_id()).isEmpty())
            return Response.status(Response.Status.BAD_REQUEST).entity("Rack id "+dto.rack_id()+" not found.").build();
        if(teamMemberRepository.findByIdOptional(dto.requester_id()).isEmpty())
            return Response.status(Response.Status.BAD_REQUEST).entity("Team member id "+dto.requester_id()+" not found.").build();
        if(dto.book_from().isAfter(dto.book_to()))
            return Response.status(Response.Status.BAD_REQUEST).entity("Booking date 'from' is after Booking date 'to'.").build();
        Booking booking = bookingMapper.toEntity(dto);
        bookingRepository.persist(booking);
        return Response.ok().entity(bookingMapper.toDto(booking)).build();
    }

    public Response getAllBookings(){
        if(bookingRepository.count()==0)
            return Response.status(Response.Status.BAD_REQUEST).entity("Não existem bookings na DB.").build();
        List<Booking> b = bookingRepository.findAll().list();
        return Response.ok().entity(b.stream().map(bookingMapper::toDto).collect(Collectors.toList())).build();
    }

    public Response getBookingById(int id){
        Optional <Booking> booking = Optional.ofNullable(bookingRepository.findById(id));
        if(booking.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("Booking with id " +id+" not found.").build();
        return Response.ok().entity(bookingMapper.toDto(booking.get())).build();
    }

    public Response deleteBooking(int id){
        if(bookingRepository.findByIdOptional(id).isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("Booking with id "+id+" not found.").build();
        return Response.ok().entity(bookingRepository.deleteById(id)).build();
    }

    public Response updateBooking(int id, BookingCreateRequestDTO dto) {
        Optional<Booking> b = bookingRepository.findByIdOptional(id);
        if(b.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("Booking with id "+id+" not found.").build();
        Booking booking = b.get();
        booking.book_to = dto.book_to();
        booking.book_from = dto.book_from();
        Optional<Rack> rack = rackRepository.findByIdOptional(dto.rack_id());
        if(rack.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("Rack id "+dto.rack_id()+" not found.").build();
        booking.rack = rack.get();
        Optional<TeamMember> teamMember = teamMemberRepository.findByIdOptional(dto.requester_id());
        if(teamMember.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("Team member id "+dto.requester_id()+" not found.").build();
        booking.teamMember = teamMember.get();
        booking.serial_number = dto.serial_number();
        booking.requester_id=dto.requester_id();
        booking.rack_id=dto.rack_id();
        booking.modified_at= LocalDateTime.now();
        bookingRepository.persist(booking);
        return Response.ok().entity(bookingMapper.toDto(booking)).build();
    }
}
