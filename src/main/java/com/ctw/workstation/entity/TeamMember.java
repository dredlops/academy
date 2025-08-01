package com.ctw.workstation.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "T_TEAM_MEMBER")
public class TeamMember{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teamMemberIdGenerator")
    @SequenceGenerator(name="teamMemberIdGenerator", sequenceName="SEQ_TEAM_MEMBER_ID")
    private int id;

    @JoinColumn(name = "TEAM_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonbTransient
    public Team team;

    @Column(name = "TEAM_ID")
    public int team_id;

    @OneToMany(mappedBy ="teamMember", fetch = FetchType.LAZY)
    @JsonbTransient
    public List<Booking> bookings;


    @Column(name="CTW_ID", nullable = false)
    public String ctw_id;

    @Column(name="NAME", nullable = false)
    public String name;

    @Column(name="CREATED_AT", nullable = false)
    @CreationTimestamp
    public LocalDateTime created_at;

    @Column(name="MODIFIED_AT", nullable = false)
    @UpdateTimestamp
    public LocalDateTime modified_at;

}