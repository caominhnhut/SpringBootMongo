package com.sts.model.userrole.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRoleCreateRequest {

    @NotNull
    private String userId;

    @NotNull
    private String roleId;

}