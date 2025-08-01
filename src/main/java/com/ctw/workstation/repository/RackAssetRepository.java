package com.ctw.workstation.repository;

import com.ctw.workstation.entity.RackAsset;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RackAssetRepository implements PanacheRepository<RackAsset> {
    public RackAsset findById(int id) {return find("id", id).firstResult();}
}
