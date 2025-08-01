package com.ctw.workstation.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

@Entity
@Table(name = "T_RACK_ASSET")
public class RackAsset {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rackAssetIdGenerator")
    @SequenceGenerator(name = "rackAssetIdGenerator", sequenceName = "SEQ_RACK_ASSET_ID")
    private int id;

    @Column(name = "ASSET_TAG", nullable = false)
    private String asset_tag;

    @Column(name="RACK_ID")
    private int rack_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rack_id", insertable = false, updatable = false)
    @JsonbTransient
    private Rack rack;

}
