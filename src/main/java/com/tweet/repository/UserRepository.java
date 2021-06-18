package com.tweet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tweet.model.RegisterUser;

public interface UserRepository extends MongoRepository<RegisterUser,Integer>{

}
