package com.hcl.bookapp.repository;

import com.hcl.bookapp.entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
