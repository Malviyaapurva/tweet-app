package com.tweet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.tweet.model.Comments;
import com.tweet.model.RegisterUser;
import com.tweet.model.Tweet;
import com.tweet.repository.CommentRepo;
import com.tweet.repository.TweetRepository;

@Service
public class CommentsService {
	private final MongoTemplate mongoTemplate;

	
	public CommentsService(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	
	@Autowired
	CommentRepo commentRepo;
	
	@Autowired
	UserService userService;
	
	public Comments submitCommentToDB(Comments comment) {
		return commentRepo.save(comment);
	}
	
	public List<Comments> getAllCommentsForDB(String postId){
		  Query query = new Query();
	        query.addCriteria(Criteria.where("postId").is(postId));
	        List<Comments> commentList = mongoTemplate.find(query, Comments.class);
		
		//ArrayList<Comments> commentList=commentRepo.findAllByPostId(postId);
		
		for(int i=0;i<commentList.size();i++) {
			Comments commentItem=commentList.get(i);
			Optional<RegisterUser> user =userService.getUserById(commentItem.getUserId());
		
			commentItem.setUserName(user.get().getFirstName());
		}
		
		return commentList;
		
	}
}