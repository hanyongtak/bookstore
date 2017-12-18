package io.pnt.edu.bookstore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.pnt.edu.bookstore.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CSVHsqldbBookServiceTest {
	@Autowired
	BookService bookService;
	
	@Test
	public void contextLoads() {
		assertEquals(4, bookService.findAll().size());
	}

}
