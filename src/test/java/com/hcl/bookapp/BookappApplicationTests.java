package com.hcl.bookapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.bookapp.entity.Book;
import com.hcl.bookapp.repository.BookRepository;
import com.hcl.bookapp.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookappApplicationTests {
	@Autowired
	BookService bookService;
	
	@MockBean
	BookRepository bookRepository;
	
	Book book;
	
	@BeforeEach
	public void initalizing() {
		book = new Book();
		book.setId(1);
		book.setTitle("Pyi's Book");
		book.setDescription("A good book");
		book.setPublishYear("2019");
		book.setPublisher("Robert");
		book.setAuthName("Aaron");
		book.setStatus(1);
	}
	
    @Test
    public void addBookTest() {
 
//    	when(repository.save(user)).thenReturn(user);
    	when(bookRepository.save(book)).thenReturn(book);
    	Book savedBook = bookService.addBook(book);
    	//assertEquals(book, bookService.addBook(book));
    	System.out.println(savedBook.getId());
    	assertNotEquals(0, savedBook.getId());
    }
    
    @Test
    public void bookListTest() {
    	List<Book> list = new ArrayList<>();
    	list.add(book);
    	when(bookRepository.findAll()).thenReturn(list);
    	assertEquals(1, list.size());
    }
    
    @Test
    public void getBookByIdTest() {
    	long id = 1;
    	when(bookRepository.getById(id)).thenReturn(book);
    	assertEquals(1, bookService.getBookById(id).getId());
    }
    
    @Test
    public void updateBookByIdTest() {
    	book.setPublisher("Yof");
    	when(bookRepository.save(book)).thenReturn(book);
    	assertEquals("Yof", bookService.updateBook(book).getPublisher());
    }
    
//    @Test
//    public void deleteBookByIdTest() {
//    	long id = 1;
//    	when(bookRepository.delete(book))
//    	assertEquals(1, bookService.deleteBookById(id));
//    }
}
