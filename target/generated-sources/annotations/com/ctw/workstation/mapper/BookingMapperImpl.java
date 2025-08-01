package com.ctw.workstation.mapper;

import com.ctw.workstation.dto.BookingCreateRequestDTO;
import com.ctw.workstation.dto.BookingDTO;
import com.ctw.workstation.entity.Booking;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-01T11:25:58+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Azul Systems, Inc.)"
)
@ApplicationScoped
public class BookingMapperImpl implements BookingMapper {

    @Override
    public Booking toEntity(BookingCreateRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Booking booking = new Booking();

        booking.rack_id = dto.rack_id();
        booking.serial_number = dto.serial_number();
        booking.requester_id = dto.requester_id();
        booking.book_from = dto.book_from();
        booking.book_to = dto.book_to();

        return booking;
    }

    @Override
    public BookingDTO toDto(Booking entity) {
        if ( entity == null ) {
            return null;
        }

        int id = 0;
        int rack_id = 0;
        int requester_id = 0;
        String serial_number = null;
        LocalDateTime book_from = null;
        LocalDateTime book_to = null;

        id = entity.id;
        rack_id = entity.rack_id;
        requester_id = entity.requester_id;
        serial_number = entity.serial_number;
        book_from = entity.book_from;
        book_to = entity.book_to;

        BookingDTO bookingDTO = new BookingDTO( id, rack_id, requester_id, serial_number, book_from, book_to );

        return bookingDTO;
    }

    @Override
    public List<BookingDTO> toDTOs(List<Booking> booking) {
        if ( booking == null ) {
            return null;
        }

        List<BookingDTO> list = new ArrayList<BookingDTO>( booking.size() );
        for ( Booking booking1 : booking ) {
            list.add( toDto( booking1 ) );
        }

        return list;
    }
}
