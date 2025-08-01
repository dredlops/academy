package com.ctw.workstation.mapper;

import com.ctw.workstation.dto.RackAssetDTO;
import com.ctw.workstation.entity.RackAsset;
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
public class RackAssetMapperImpl implements RackAssetMapper {

    @Override
    public RackAsset toEntity(RackAssetDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RackAsset rackAsset = new RackAsset();

        return rackAsset;
    }

    @Override
    public RackAssetDTO toDto(RackAsset entity) {
        if ( entity == null ) {
            return null;
        }

        int id = 0;
        String asset_tag = null;
        int rack_id = 0;

        RackAssetDTO rackAssetDTO = new RackAssetDTO( id, asset_tag, rack_id );

        return rackAssetDTO;
    }

    @Override
    public List<RackAssetDTO> toDtos(List<RackAsset> rackAssets) {
        if ( rackAssets == null ) {
            return null;
        }

        List<RackAssetDTO> list = new ArrayList<RackAssetDTO>( rackAssets.size() );
        for ( RackAsset rackAsset : rackAssets ) {
            list.add( toDto( rackAsset ) );
        }

        return list;
    }
}
