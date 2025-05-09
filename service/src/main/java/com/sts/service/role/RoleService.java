package com.sts.service.role;

import com.sts.model.role.dto.RoleDto;
import com.sts.model.role.request.RoleCreateRequest;
import com.sts.model.role.request.RoleUpdateRequest;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<RoleDto> getAllRoles();

    Optional<RoleDto> getRoleById(ObjectId id);

    RoleDto createRole(RoleCreateRequest role);

    RoleDto updateRole(ObjectId id, RoleUpdateRequest roleDetails);

    void deleteRole(ObjectId id);

}
