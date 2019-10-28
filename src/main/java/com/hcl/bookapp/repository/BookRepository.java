package com.hcl.bookapp.repository;

import com.hcl.bookapp.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
	Book getById(long id);
}
