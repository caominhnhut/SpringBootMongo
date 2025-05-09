package com.sts.service.mapper;

import com.sts.entity.UserEntity;
import com.sts.model.user.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", expression = "java(userEntity.getId().toHexString())")
    UserDto toDto(UserEntity userEntity);

}
