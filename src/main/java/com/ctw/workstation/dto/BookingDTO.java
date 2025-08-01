package com.ctw.workstation.dto;

import java.time.LocalDateTime;

public record BookingDTO(int id,
                         int rack_id,
                         int requester_id,
                         String serial_number,
                         LocalDateTime book_from,
                         LocalDateTime book_to) {}
