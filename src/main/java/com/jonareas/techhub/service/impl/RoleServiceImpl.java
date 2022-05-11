package com.jonareas.techhub.service.impl;

import com.jonareas.techhub.model.Instructor;
import com.jonareas.techhub.model.Role;
import com.jonareas.techhub.repository.RoleRepository;
import com.jonareas.techhub.repository.TopicRepository;
import com.jonareas.techhub.service.InstructorService;
import com.jonareas.techhub.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Long> implements RoleService {

   private RoleRepository repository;

    @Autowired
    RoleServiceImpl(RoleRepository repository) {
        super(repository);
    }

}
