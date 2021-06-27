package io.honeymon.tacademy.springboot.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)//Test 실행될 환경을 선언
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class BookServiceTest {

	@Autowired
	BookService bookService;
	
	//@Test(expected = RuntimeException.class)
	@Test
	public void testFindById() {
		Long id = 1L;
		bookService.findById(id)
				.orElseThrow(() -> new RuntimeException("Not found"));
	}
}
