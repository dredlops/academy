package com.ctw.workstation.repository;

import com.ctw.workstation.entity.Booking;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookingRepository implements PanacheRepositoryBase<Booking, Integer> {

    //Faz mapeamento de Dto para Entidade
    public Booking findById(int id) {
        return find("id", id).firstResult();
    }


}
