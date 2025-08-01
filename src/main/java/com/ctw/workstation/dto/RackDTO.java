package com.ctw.workstation.dto;

import com.ctw.workstation.entity.Status;

public record RackDTO(int id,
                      String serialNumber,
                      Status status,
                      int team_id,
                      String default_location){}
