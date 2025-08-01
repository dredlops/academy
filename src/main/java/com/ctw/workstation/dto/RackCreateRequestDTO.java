package com.ctw.workstation.dto;

import com.ctw.workstation.entity.Status;

import java.time.LocalDateTime;


public record RackCreateRequestDTO (String serialNumber,
                                    LocalDateTime assembledAt,
                                    Status status,
                                    int team_id,
                                    String default_location){}
