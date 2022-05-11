package com.jonareas.techhub.service.impl;

import com.jonareas.techhub.model.User;
import com.jonareas.techhub.repository.BaseRepository;
import com.jonareas.techhub.repository.UserRepository;
import com.jonareas.techhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

    private UserRepository repository;

    @Autowired
    UserServiceImpl(UserRepository repository) {
        super(repository);
    }

}
