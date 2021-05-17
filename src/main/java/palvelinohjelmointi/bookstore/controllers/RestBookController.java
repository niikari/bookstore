package palvelinohjelmointi.bookstore.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import palvelinohjelmointi.bookstore.models.Book;
import palvelinohjelmointi.bookstore.repositories.BookRepository;

@RestController
public class RestBookController {
	
	@Autowired
	private BookRepository bookRepository;
		
	@GetMapping("/books")
	public Iterable<Book> returnBooks() {
		return this.bookRepository.findAll();
	}
	
	@GetMapping("/books/{id}")
	public Optional<Book> returnBookById(@PathVariable(value="id") Long id) {
		
		return this.bookRepository.findById(id);
	}
	
	@GetMapping("/books/{author}")
	public List<Book> returnBooksByAuthor(@PathVariable(value="author") String author) {
		
		return this.bookRepository.findByAuthor(author);
	}
	
	@PostMapping("/books")
	public Book addNewBook(@RequestBody Book book) {
		
		return this.bookRepository.save(book);
	}
}
