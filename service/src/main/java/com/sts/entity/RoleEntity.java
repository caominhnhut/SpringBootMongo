package com.sts.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.io.Serializable;

@Document(collection = "roles")
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEntity extends AuditMetaData implements Serializable {

    @Serial
    private static final long serialVersionUID = 12342343L;

    @Id
    private ObjectId id;

    @Setter
    @Field(name = "role_name")
    private String roleName;

}
