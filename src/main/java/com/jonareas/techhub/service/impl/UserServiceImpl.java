package com.jonareas.techhub.service.impl;

import com.jonareas.techhub.model.User;
import com.jonareas.techhub.repository.UserRepository;
import com.jonareas.techhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

    private UserRepository repository;

    private final PasswordEncoder encoder;

    @Autowired
    UserServiceImpl(UserRepository repository, PasswordEncoder encoder) {
        super(repository);
        this.encoder = encoder;
    }

    @Override
    public User create(User entity) throws Exception {
        String encodedPassword = encoder.encode(entity.getPassword());
        entity.setPassword(encodedPassword);
        return super.create(entity);
    }
}
