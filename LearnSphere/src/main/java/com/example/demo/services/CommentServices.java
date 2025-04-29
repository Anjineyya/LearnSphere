package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Comments;

public interface CommentServices {
	
	List<Comments> commentsList();
	String addComment(Comments comment);

}
