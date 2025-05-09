package com.sts.service.userrole;

import com.sts.entity.UserRoleEntity;
import com.sts.model.userrole.dto.UserRoleDto;
import com.sts.model.userrole.request.UserRoleCreateRequest;
import com.sts.model.userrole.request.UserRoleUpdateRequest;
import com.sts.repository.UserRoleRepository;
import com.sts.service.mapper.UserRoleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    private final UserRoleMapper userRoleMapper;

    @Override
    public List<UserRoleDto> getAllUserRoles() {
        return userRoleRepository.findAll().stream()
                .map(userRoleMapper::toDto)
                .toList();
    }

    @Override
    public Optional<UserRoleDto> getUserRoleById(ObjectId id) {
        return userRoleRepository.findById(id)
                .map(userRoleMapper::toDto);
    }

    @Override
    public UserRoleDto createUserRole(UserRoleCreateRequest userRoleRequest) {
        var userRoleEntity = UserRoleEntity.builder()
                .userId(new ObjectId(userRoleRequest.getUserId()))
                .roleId(new ObjectId(userRoleRequest.getRoleId()))
                .build();
        var savedUserRole = userRoleRepository.save(userRoleEntity);
        return userRoleMapper.toDto(savedUserRole);
    }

    @Override
    public UserRoleDto updateUserRole(ObjectId id, UserRoleUpdateRequest userRoleDetails) {
        return userRoleRepository.findById(id)
                .map(existingUserRole -> {
                    existingUserRole.setRoleId(new ObjectId(userRoleDetails.getRoleId()));
                    existingUserRole.setUserId(new ObjectId(userRoleDetails.getUserId()));
                    return userRoleMapper.toDto(userRoleRepository.save(existingUserRole));
                })
                .orElseThrow(() -> new RuntimeException("UserRole not found"));
    }

    @Override
    public void deleteUserRole(ObjectId id) {
        userRoleRepository.deleteById(id);
    }

}
