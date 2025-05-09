package com.sts.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Document(collection = "users")
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity extends AuditMetaData implements Serializable {

    @Serial
    private static final long serialVersionUID = 45345343L;

    @Id
    private ObjectId id;

    private String email;

    @Setter
    private String name;

    @ToString.Exclude
    private String password;

    private UserStatus status;

}
