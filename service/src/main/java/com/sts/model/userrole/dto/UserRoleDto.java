package com.sts.model.userrole.dto;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRoleDto {

    private String id;

    private String userId;

    private String roleId;

}
