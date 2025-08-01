package com.ctw.workstation.dto;

import com.ctw.workstation.entity.Booking;
import com.ctw.workstation.entity.Team;

import java.util.List;


public record TeamMemberDTO(int id, int team_id, List<Booking> bookings, String ctw_id, String name){}
