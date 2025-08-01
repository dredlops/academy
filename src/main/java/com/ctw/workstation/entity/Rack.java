package com.ctw.workstation.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_RACK")
public class Rack extends PanacheEntityBase {
    private static final String GET_ALL = "Rack.getAll";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rackIdGenerator")
    @SequenceGenerator(name = "rackIdGenerator", sequenceName = "SEQ_RACK_ID")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public int id;

    @Column(name = "SERIAL_NUMBER", length = 20, nullable = false)
    public String serialNumber;

    @Column(name = "ASSEMBLED_AT", nullable = false)
    @CreationTimestamp
    public LocalDateTime assembledAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    public Status status;

    @Column(name = "DEFAULT_LOCATION")
    public String default_location;

    @Column(name = "CREATED_AT", nullable = false)
    @CreationTimestamp
    public LocalDateTime created_at;

    @Column(name = "MODIFIED_AT", nullable = false)
    @UpdateTimestamp
    public LocalDateTime modified_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
    @JsonbTransient
    public Team team;

    @Column(name = "TEAM_ID")
    public int team_id;

    @OneToMany(mappedBy = "rack", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonbTransient
    public List<RackAsset> rackAssets = new ArrayList<>();

    @OneToMany(mappedBy = "rack", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonbTransient
    public List<Booking> bookings = new ArrayList<>();

}
