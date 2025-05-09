package com.sts.repository;

import com.sts.entity.UserRoleEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRoleRepository extends MongoRepository<UserRoleEntity, ObjectId> {

    Set<UserRoleEntity> findByUserId(ObjectId userId);

}
