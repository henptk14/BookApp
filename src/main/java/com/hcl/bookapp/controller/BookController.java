package com.hcl.bookapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bookapp.entity.Book;
import com.hcl.bookapp.service.BookService;
import com.hcl.bookapp.service.MapValidationErrorService;

@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> addBook(@Valid @RequestBody Book book, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
		if(errorMap != null) {
			return errorMap;
		}
		
		return new ResponseEntity<Book>(bookService.addBook(book), HttpStatus.CREATED);
	}
	
	@GetMapping("/booklist")
	public Iterable<Book> getBookList() {
		return bookService.getBookList();
	}
	
	@PutMapping("/updatebook")
	public ResponseEntity<?> updateBook(@Valid @RequestBody Book updatedBook, BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
		if(errorMap != null) {
			return errorMap;
		}
		
		return new ResponseEntity<Book>(bookService.updateBook(updatedBook), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBookById(@PathVariable long id) {
		return new ResponseEntity<Book>(bookService.getBookById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBookById(@PathVariable long id) {
		
		return new ResponseEntity<Book>(bookService.deleteBookById(id), HttpStatus.OK);
	}
	
}
