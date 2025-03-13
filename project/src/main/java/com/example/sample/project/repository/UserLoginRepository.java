package com.example.sample.project.repository;

import com.example.sample.project.domain.UserLogin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends MongoRepository<UserLogin,String> {

    UserLogin findByUserId(String userId);
}
