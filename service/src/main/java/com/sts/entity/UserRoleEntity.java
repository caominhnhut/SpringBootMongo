package com.sts.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.io.Serializable;

@Document(collection = "user_roles")
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRoleEntity extends AuditMetaData implements Serializable {

    @Serial
    private static final long serialVersionUID = 327894678329L;

    @Id
    private ObjectId id;

    @Setter
    @Field(name = "user_id")
    private ObjectId userId;

    @Setter
    @Field(name = "role_id")
    private ObjectId roleId;

}
