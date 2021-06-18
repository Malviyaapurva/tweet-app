package com.tweet.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tweet.model.RegisterUser;
import com.tweet.repository.UserRepository;

@Service
public class UserService {
	private final MongoTemplate mongoTemplate;
	@Autowired
	public UserRepository userRepository;
	
	public UserService(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	public String loginUser(String username,String password){
		  Query query = new Query();
	        query.addCriteria(Criteria.where("email").is(username)).addCriteria(Criteria.where("password").is(password));
	        List<RegisterUser> userDetails =  mongoTemplate.find(query, RegisterUser.class);
	        if(userDetails.size()!=0) {
	        	//update login status
	        	return "user logged in"; }
	        else
	        	return "invalid user name password";
		
	        }
	
	public String createUser( RegisterUser registerUser) {
		userRepository.save(registerUser);
		return "";
				}
	
	public List<RegisterUser> getAllUser(){
		return userRepository.findAll();
	}

	public Optional<RegisterUser> getUserById(int id){
		return userRepository.findById(id);
		
	}

}
