package com.ctw.workstation.mapper;

import com.ctw.workstation.dto.RackAssetDTO;
import com.ctw.workstation.entity.RackAsset;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface RackAssetMapper {
    RackAsset toEntity(RackAssetDTO dto);
    RackAssetDTO toDto(RackAsset entity);
    List<RackAssetDTO> toDtos (List<RackAsset> rackAssets);
}
