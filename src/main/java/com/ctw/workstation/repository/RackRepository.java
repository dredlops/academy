package com.ctw.workstation.repository;

import com.ctw.workstation.entity.Rack;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RackRepository implements PanacheRepositoryBase<Rack, Integer> {

    public Rack findById(int id) {return Rack.find("id", id).firstResult();}
}
