package com.sts.service.userrole;

import com.sts.model.userrole.dto.UserRoleDto;
import com.sts.model.userrole.request.UserRoleCreateRequest;
import com.sts.model.userrole.request.UserRoleUpdateRequest;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface UserRoleService {

    List<UserRoleDto> getAllUserRoles();

    Optional<UserRoleDto> getUserRoleById(ObjectId id);

    UserRoleDto createUserRole(UserRoleCreateRequest userRoleRequest);

    UserRoleDto updateUserRole(ObjectId id, UserRoleUpdateRequest userRoleDetails);

    void deleteUserRole(ObjectId id);

}
