package com.tweet.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tweet.model.Comments;

public interface CommentRepo  extends MongoRepository<Comments,Integer> {

	ArrayList<Comments> findAllByPostId(String postId);

}
