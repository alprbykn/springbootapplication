package com.aby.repo;

import com.aby.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {
    //MongoRepository provides methods for CRUD operation
    User findByUsername(String username);
}
