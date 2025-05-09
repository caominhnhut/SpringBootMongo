package com.sts.service.mapper;

import com.sts.entity.RoleEntity;
import com.sts.model.role.dto.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "id", expression = "java(roleEntity.getId().toHexString())")
    RoleDto toDto(RoleEntity roleEntity);

}
