package com.sts.service.user;

import com.sts.model.user.dto.UserDto;
import com.sts.model.user.request.UserCreateRequest;
import com.sts.model.user.request.UserUpdateRequest;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> getAllUsers();

    Optional<UserDto> getUserById(ObjectId id);

    UserDto createUser(UserCreateRequest userRequest);

    UserDto updateUser(ObjectId id, UserUpdateRequest userDetails);

    void deleteUser(ObjectId id);

}
