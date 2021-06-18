package com.tweet.controller;

import java.util.List;
import java.util.Optional;


import javax.validation.Valid;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tweet.TweetAppApplication;
import com.tweet.model.RegisterUser;
import com.tweet.model.Tweet;
import com.tweet.publisher.KafkaPublisher;
import com.tweet.repository.TweetRepository;
import com.tweet.repository.UserRepository;
import com.tweet.service.TweetService;
import com.tweet.service.UserService;
import com.tweet.util.Utils;

@RestController
@RequestMapping("/api/v1.0/tweets")
public class TweetController {
	
	@Autowired
	private TweetService tweetService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TweetRepository tweetRepository;
	@Autowired
	private Utils utils;
	
	private final KafkaPublisher kafkaPublisher;

    @Autowired
    public TweetController(KafkaPublisher kafkaPublisher) {
        this.kafkaPublisher = kafkaPublisher;
    }
	
	Logger logger = LoggerFactory.getLogger(TweetController.class);
	
	@PostMapping("/register")
	public String createUser(@Valid @RequestBody RegisterUser registerUser) {
		if(!utils.isValidEmail(registerUser.getEmail())) {
			return "Please enter valid email";
		}

		if(utils.isValidPassword(registerUser.getPassword()) &&
				registerUser.getPassword().equals(registerUser.getConfirmPassword())){
			userService.createUser(registerUser);} 
		else {
			return "please enter correct password";
		}
		return "Added book with id " + registerUser.getLoginId();
		}
	
	@GetMapping("/users/all")
	public List<RegisterUser> getAllUser(){
		return userService.getAllUser();
	}

	@GetMapping("user/search/{id}")
	public Optional<RegisterUser> getUserById(@PathVariable int id){
		return userService.getUserById(id);
		}
	
	@DeleteMapping("/delete/{id}")
	public String deleteTweet(@PathVariable int id){
		tweetService.deleteTweet(id);
		return "User Deleted with id "+ id;
		}
	
	@GetMapping("/login")
	public String loginUser(@QueryParam("username") String username,@QueryParam("password") String password){
	
		return userService.loginUser(username,password);
		
		}
	
	@GetMapping("/{username}/forgot")
	public String forgetPassword(@PathVariable String username){
		return "todo";
		
		}
	
	@GetMapping("/all")
	public List<Tweet> findAllTweet(){
		 return tweetService.findAllTweet();
		}
	
	@GetMapping("/user/search")
	public List<RegisterUser> searchByUserName(@QueryParam("username") String username){
		 
		return tweetService.searchByUserName(username);
	        
		}
	
	@GetMapping("/findbyuser")
	public List<String> getTweetByUserName(@QueryParam("username") String username){
		return tweetService.getTweetByUserName(username);
		}
	
	@PostMapping("/add")
	public String getTweetByUserName(@RequestBody Tweet tweet){
//		tweet.setTimeStamp(new java.util.Date().toString());
//		tweetRepository.save(tweet);
		kafkaPublisher.sendMessage(tweet);
		 return "Tweet get saved";
		}
	
	@PutMapping("/update")
	public String updateTweet(@RequestBody Tweet tweet){
		tweet.setTimeStamp(new java.util.Date().toString());
		 return "Todo";
		}
	
	
}
