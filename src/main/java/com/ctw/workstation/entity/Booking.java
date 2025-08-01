package com.ctw.workstation.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "T_BOOKING")
public class Booking{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingIdGenerator")
    @SequenceGenerator(name = "bookingIdGenerator", sequenceName = "SEQ_BOOKING_ID")
    public int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RACK_ID", insertable = false, updatable = false)
    @JsonbTransient
    public Rack rack;

    @Column(name = "RACK_ID")
    public int rack_id;

    @Column(name = "SERIAL_NUMBER")
    public String serial_number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUESTER_ID", insertable = false, updatable = false)
    @JsonbTransient
    public TeamMember teamMember;

    @Column(name = "REQUESTER_ID")
    public int requester_id;

    @Column(name="BOOK_FROM", nullable = false)
    public LocalDateTime book_from;

    @Column(name="BOOK_TO", nullable = false)
    public LocalDateTime book_to;

    @Column(name="CREATED_AT", nullable = false)
    @CreationTimestamp
    public LocalDateTime created_at;

    @Column(name="MODIFIED_AT", nullable = false)
    @UpdateTimestamp
    public LocalDateTime modified_at;

}
