package com.ctw.workstation.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "T_TEAM")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teamIdGenerator")
    @SequenceGenerator(name = "teamIdGenerator", sequenceName = "SEQ_TEAM_ID")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    @JsonbTransient
    private List<Rack> racks;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    @JsonbTransient
    private List<TeamMember> teamMembers;

    @Column(name = "PRODUCT", nullable = false)
    public String product;

    @Column(name = "DEFAULT_LOCATION", nullable = false)
    public String defaultLocation;

    @Column(name = "CREATED_AT", nullable = false)
    @CreationTimestamp
    public LocalDateTime createdAt;

    @Column(name = "MODIFIED_AT", nullable = false)
    @CreationTimestamp
    public LocalDateTime modifiedAt;


}
