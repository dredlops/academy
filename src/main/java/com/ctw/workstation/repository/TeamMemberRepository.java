package com.ctw.workstation.repository;

import com.ctw.workstation.entity.TeamMember;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TeamMemberRepository implements PanacheRepositoryBase<TeamMember, Integer> {

    public TeamMember findById(int id){
        return find("id", id).firstResult();
    }

}
