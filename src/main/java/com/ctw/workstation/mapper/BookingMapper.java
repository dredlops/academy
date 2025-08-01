package com.ctw.workstation.mapper;

import com.ctw.workstation.dto.BookingCreateRequestDTO;
import com.ctw.workstation.dto.BookingDTO;
import com.ctw.workstation.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;



@Mapper(componentModel = "cdi")
public interface BookingMapper {

    Booking toEntity(BookingCreateRequestDTO dto);
    BookingDTO toDto(Booking entity);
    List<BookingDTO> toDTOs(List<Booking> booking);
}
