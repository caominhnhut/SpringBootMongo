package com.sts.service.role;

import com.sts.entity.RoleEntity;
import com.sts.model.role.dto.RoleDto;
import com.sts.model.role.request.RoleCreateRequest;
import com.sts.model.role.request.RoleUpdateRequest;
import com.sts.repository.RoleRepository;
import com.sts.service.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    @Override
    public List<RoleDto> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(roleMapper::toDto)
                .toList();
    }

    @Override
    public Optional<RoleDto> getRoleById(ObjectId id) {
        return roleRepository.findById(id)
                .map(roleMapper::toDto);
    }

    @Override
    public RoleDto createRole(RoleCreateRequest roleRequest) {
        var roleEntity = RoleEntity.builder()
                .roleName(roleRequest.getName())
                .build();
        var savedRole = roleRepository.save(roleEntity);
        return roleMapper.toDto(savedRole);
    }

    @Override
    public RoleDto updateRole(ObjectId id, RoleUpdateRequest roleDetails) {
        return roleRepository.findById(id)
                .map(existingRole -> {
                    existingRole.setRoleName(roleDetails.getName());
                    return roleMapper.toDto(roleRepository.save(existingRole));
                })
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }

    @Override
    public void deleteRole(ObjectId id) {
        roleRepository.deleteById(id);
    }

}
