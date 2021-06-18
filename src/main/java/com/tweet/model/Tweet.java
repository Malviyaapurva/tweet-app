package com.tweet.model;

import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Tweet")
@ToString
public class Tweet {
	@Id
	@GeneratedValue
 private int id;
 private String tweetId;
 private int userId;
 private String userame;
 private String tweetDesc;
 private String timeStamp;
 private int likeCount;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTweetId() {
	return tweetId;
}
public void setTweetId(String tweetId) {
	this.tweetId = tweetId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUsername() {
	return getUsername();
}
public void setUsername(String username) {
	this.userame = username;
}
public String getTweetDesc() {
	return tweetDesc;
}
public void setTweetDesc(String tweetDesc) {
	this.tweetDesc = tweetDesc;
}
public String getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(String timeStamp) {
	this.timeStamp = timeStamp;
}
public int getLikeCount() {
	return likeCount;
}
public void setLikeCount(int likeCount) {
	this.likeCount = likeCount;
}
public Tweet(int id, String tweetId, int userId, String username, String tweetDesc, String timeStamp,
		int likeCount) {
	super();
	this.id = id;
	this.tweetId = tweetId;
	this.userId = userId;
	this.userame = username;
	this.tweetDesc = tweetDesc;
	this.timeStamp = timeStamp;
	this.likeCount = likeCount;
}
public Tweet() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Tweet [id=" + id + ", tweetId=" + tweetId + ", userId=" + userId + ", username=" + userame + ", tweetDesc="
			+ tweetDesc + ", timeStamp=" + timeStamp + ", likeCount=" + likeCount + "]";
}
 
 
}
