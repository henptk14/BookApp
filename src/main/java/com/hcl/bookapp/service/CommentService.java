package com.hcl.bookapp.service;

import com.hcl.bookapp.entity.Comment;
import com.hcl.bookapp.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    
    public Comment addComment(Comment comment) {
    	return commentRepository.save(comment);
    }
}
