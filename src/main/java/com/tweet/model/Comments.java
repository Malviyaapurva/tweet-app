package com.tweet.model;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Comments")
public class Comments {
	@Id
	@GeneratedValue
	private int id;
	
	private String commentId;
	private int userId;
	private String postId;
	private Timestamp timeStamp;
	private String comment;
	private String userName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Comments [id=" + id + ", commentId=" + commentId + ", userId=" + userId + ", postId=" + postId
				+ ", timeStamp=" + timeStamp + ", comment=" + comment + ", userName=" + userName + "]";
	}
	public Comments(int id, String commentId, int userId, String postId, Timestamp timeStamp, String comment,
			String userName) {
		super();
		this.id = id;
		this.commentId = commentId;
		this.userId = userId;
		this.postId = postId;
		this.timeStamp = timeStamp;
		this.comment = comment;
		this.userName = userName;
	}
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
