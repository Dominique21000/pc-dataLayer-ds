package com.openclassrooms.datalayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.datalayer.model.Comment;
import com.openclassrooms.datalayer.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public Iterable<Comment> getComments(){
		return commentRepository.findAll();
	}
	
	public Optional<Comment> getCommentById(int id) {
		return commentRepository.findById(id);
	}
	
	public void deleteCommentaire(Integer id) {
		commentRepository.deleteById(id);
	}
	
	public Iterable<Comment> getCommentByContent(String weywords){
		return commentRepository.findCommentByContentContaining(weywords);
	}
}
