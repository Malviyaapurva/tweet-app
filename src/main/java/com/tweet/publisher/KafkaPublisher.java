package com.tweet.publisher;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tweet.model.Tweet;


@Service
public class KafkaPublisher {

	
	@Value("${kafka.topic}")
	String topic;
	@Autowired
	private KafkaTemplate<String,String> KafkaTemplate;
	
	public boolean sendMessage(Tweet message) {
		ObjectMapper mapper = new ObjectMapper();
		boolean isSentMsg = true;
		try {
		    String msg = mapper.writeValueAsString(message);
		   // log.info(String.format("Before Message", msg));
		    this.KafkaTemplate.send(topic,msg);
		   // log.info(String.format("After Message", msg));
		  
		} catch (Exception e) {
		    isSentMsg = false;
		   // log.error(String.format("Error mesage", e));
		}
		
		return isSentMsg;
		
	}
	  @Bean
	    public NewTopic createTopic(){

	        return new NewTopic(topic,3,(short) 1);
	    }
}

