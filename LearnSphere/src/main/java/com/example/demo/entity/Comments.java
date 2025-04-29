package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int commentId;
	String Comments;
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comments(int commentId, String comments) {
		super();
		this.commentId = commentId;
		Comments = comments;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", Comments=" + Comments + "]";
	}
	
}
