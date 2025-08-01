package com.ctw.workstation.repository;

import com.ctw.workstation.entity.Team;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TeamRepository implements PanacheRepositoryBase<Team, Integer> {

    public Team findById(int id) {
        return find("id", id).firstResult();
    }
}
