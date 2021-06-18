package com.tweet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tweet.model.Tweet;

public interface TweetRepository extends MongoRepository<Tweet,Integer> {

}
