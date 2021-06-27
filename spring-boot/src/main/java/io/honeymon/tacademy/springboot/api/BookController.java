package io.honeymon.tacademy.springboot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.honeymon.tacademy.springboot.domain.Book;
import io.honeymon.tacademy.springboot.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/{bookId}")
	public ResponseEntity<Book> findById(Long bookId){
		Book book = bookService.findById(bookId).orElseThrow(() -> new RuntimeException("Not found: "+bookId));
		return ResponseEntity.ok(book);
		//받은게 비어있으면 해당 아이디값이 나오고 없으면 Not found 나옴.. 
	}
}
