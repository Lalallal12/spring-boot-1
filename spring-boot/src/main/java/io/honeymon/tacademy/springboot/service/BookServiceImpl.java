package io.honeymon.tacademy.springboot.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.honeymon.tacademy.springboot.domain.Book;
import io.honeymon.tacademy.springboot.domain.BookRepository;

@Service
@Transactional//수정, 삭제를 만들 때 사용
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}


	@Override
	public Optional<Book> findById(Long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id);
	}

}
