package io.honeymon.tacademy.springboot.service;

import java.util.Optional;

import io.honeymon.tacademy.springboot.domain.Book;

public interface BookService {

	Optional<Book> findById(Long id);
}
