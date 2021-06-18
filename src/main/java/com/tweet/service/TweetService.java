package com.tweet.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tweet.model.RegisterUser;
import com.tweet.model.Tweet;
import com.tweet.repository.TweetRepository;

@Service
public class TweetService {

	private final MongoTemplate mongoTemplate;
	@Autowired
	public TweetRepository tweetRepository;
	@Autowired
	public UserService userService;
	
	public TweetService(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	public List<RegisterUser> searchByUserName(String username){
		  Query query = new Query();
	        query.addCriteria(Criteria.where("email").is(username));
	        return mongoTemplate.find(query, RegisterUser.class);
			}
	
	public List<String> getTweetByUserName(String username){
		List<String> tweetDesc = new ArrayList<String>();
		  Query query = new Query();
	        query.addCriteria(Criteria.where("username").is(username));
	        List<Tweet> tweetDetails = mongoTemplate.find(query, Tweet.class);
	        for(int i= 0;i< tweetDetails.size();i++) {
	        	tweetDesc.add(tweetDetails.get(i).getTweetDesc());
	        }
	        return tweetDesc;
			}

	public String deleteTweet( int id){ 
		tweetRepository.deleteById(id);
		return "User Deleted with id "+ id;
	}
	
	public List<Tweet> findAllTweet(){
		List<Tweet> tweetList = tweetRepository.findAll();
		
		for(int i=0;i<tweetList.size();i++) {
			Tweet postItem=tweetList.get(i);
			Optional<RegisterUser> userList=userService.getUserById(postItem.getUserId());
			postItem.setUsername(userList.get().getFirstName());
		}
		Collections.sort(tweetList,(a,b)->b.getId()-a.getId());
		return tweetList;
	}
	
	
}
