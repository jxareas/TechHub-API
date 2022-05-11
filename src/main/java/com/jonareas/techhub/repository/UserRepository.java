package com.jonareas.techhub.repository;

import com.jonareas.techhub.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    User findOneByUsername(String username);

}
