package com.tweet.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tweet.model.Tweet;
import com.tweet.repository.TweetRepository;

@Service
public class KafkaConsumer {
	@Autowired
	private TweetRepository tweetRepository;

	@KafkaListener(topics = "Tweet.topic",groupId = "group_id")
	public void consumeMessage(ConsumerRecord<String, String> data) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Tweet tweetMessage = objectMapper.readValue(data.value(), Tweet.class);
		tweetMessage.setTimeStamp(new java.util.Date().toString());
		tweetRepository.save(tweetMessage);
		
	}

}
