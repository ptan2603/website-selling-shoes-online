package com.poly.bangiaybe.serviceimpl;

import org.springframework.stereotype.Service;

import com.poly.bangiaybe.entity.Role;
import com.poly.bangiaybe.repository.RoleRepo;
import com.poly.bangiaybe.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
    RoleRepo roleRepo;

    @Override
    public Role findById(Long id) {
        return roleRepo.findById(id).get();
    }
}
