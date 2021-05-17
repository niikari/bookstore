package palvelinohjelmointi.bookstore.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import palvelinohjelmointi.bookstore.models.Book;
import palvelinohjelmointi.bookstore.repositories.BookRepository;
import palvelinohjelmointi.bookstore.repositories.CategoryRepository;

@RestController
public class RestBookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/books")
	public Iterable<Book> returnBooks() {
		return this.bookRepository.findAll();
	}
	
	@GetMapping("/books/{id}")
	public Optional<Book> returnBookById(@PathVariable(value="id") Long id) {
		
		return this.bookRepository.findById(id);
	}
}
