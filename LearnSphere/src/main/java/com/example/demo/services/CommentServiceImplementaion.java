package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Comments;
import com.example.demo.repository.CommentRepository;

@Service
public class CommentServiceImplementaion implements CommentServices {

	@Autowired
	CommentRepository commentRepo;
	@Override
	public List<Comments> commentsList() {
		return commentRepo.findAll();
	}

	@Override
	public String addComment(Comments comment) {
		commentRepo.save(comment);
		return null;
	}

}
