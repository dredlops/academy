package com.ctw.workstation.mapper;

import com.ctw.workstation.dto.RackCreateRequestDTO;
import com.ctw.workstation.dto.RackDTO;
import com.ctw.workstation.entity.Rack;
import com.ctw.workstation.entity.Status;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-01T11:25:58+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Azul Systems, Inc.)"
)
@ApplicationScoped
public class RackMapperImpl implements RackMapper {

    @Override
    public Rack toEntity(RackCreateRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Rack rack = new Rack();

        rack.serialNumber = dto.serialNumber();
        rack.assembledAt = dto.assembledAt();
        rack.status = dto.status();
        rack.default_location = dto.default_location();
        rack.team_id = dto.team_id();

        return rack;
    }

    @Override
    public RackDTO toDto(Rack entity) {
        if ( entity == null ) {
            return null;
        }

        int id = 0;
        String serialNumber = null;
        Status status = null;
        int team_id = 0;
        String default_location = null;

        id = entity.id;
        serialNumber = entity.serialNumber;
        status = entity.status;
        team_id = entity.team_id;
        default_location = entity.default_location;

        RackDTO rackDTO = new RackDTO( id, serialNumber, status, team_id, default_location );

        return rackDTO;
    }

    @Override
    public List<RackDTO> toDtos(List<Rack> racks) {
        if ( racks == null ) {
            return null;
        }

        List<RackDTO> list = new ArrayList<RackDTO>( racks.size() );
        for ( Rack rack : racks ) {
            list.add( toDto( rack ) );
        }

        return list;
    }
}
