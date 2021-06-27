package io.honeymon.tacademy.springboot.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	BookRepository repository;
	
	@Test
	public void testSave() {
		Book book =new Book();
		book.setName("boot-spring-boot");
		book.setIsbn10("0123456789");
		book.setIsbgn13("0123456789012");
		
		assertThat(book.isNew()).isTrue();
		//id값을 갖고있지 않은 새로운 객체다 확인
		
		repository.save(book);

		assertThat(book.isNew()).isFalse();
	}
	
	@Test
	public void testFindByNameLike() {
	
		Book book =new Book();
		book.setName("boot-spring-boot");
		book.setIsbn10("0123456789");
		book.setIsbgn13("0123456789012");
		
		assertThat(book.isNew()).isTrue();
		
		repository.save(book);

		List<Book> books = repository.findByNameLike("boot");
		assertThat(books).isNotEmpty();
		
		books=repository.findByNameLike("book");
		assertThat(books).isEmpty();
		
	}
	
	
}
