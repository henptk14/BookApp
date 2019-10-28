package com.hcl.bookapp.service;

import com.hcl.bookapp.entity.Book;
import com.hcl.bookapp.exceptions.CustomException;
import com.hcl.bookapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
    
    public Iterable<Book> getBookList() {
    	return bookRepository.findAll();
    }
    
    public Book getBookById(long id) {
    	Book book = bookRepository.getById(id);
    	if(book == null) {
    		throw new CustomException("Book ID '" + id + "' does not exist");
    	}
    	return book;
    }
    
    public Book updateBook(Book updatedBook) {
    	Book book = getBookById(updatedBook.getId());
    	if(book == null) {
    		throw new CustomException("Book ID '" + updatedBook.getId() + "' does not exist");
    	}
    	book.setTitle(updatedBook.getTitle());
		book.setDescription(updatedBook.getDescription());
		book.setPublishYear(updatedBook.getPublishYear());
		book.setPublisher(updatedBook.getPublisher());
		book.setAuthName(updatedBook.getAuthName());
		book.setStatus(updatedBook.getStatus());
		
		return bookRepository.save(book);
    }
    
    public Book deleteBookById(long id) {
    	Book book = bookRepository.getById(id);
    	
    	if(book == null) {
    		throw new CustomException("Book ID '" + id + "' does not exist");
    	}
    	bookRepository.delete(book);
    	return book;
    }
}
