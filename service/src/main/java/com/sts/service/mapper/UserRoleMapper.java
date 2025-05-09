package com.sts.service.mapper;

import com.sts.entity.UserRoleEntity;
import com.sts.model.userrole.dto.UserRoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    @Mapping(target = "id", expression = "java(userRoleEntity.getId().toHexString())")
    @Mapping(target = "userId", expression = "java(userRoleEntity.getUserId().toHexString())")
    @Mapping(target = "roleId", expression = "java(userRoleEntity.getRoleId().toHexString())")
    UserRoleDto toDto(UserRoleEntity userRoleEntity);

}
