package me.docu.books;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable Long id) {
		Book book = new Book();
		book.setId(id);
		book.setAuthor("wonho");
		book.setTitle("Spring Boot");
		book.setPublishedAt(new Date());
		return book;
	}
}
