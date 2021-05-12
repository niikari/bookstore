package palvelinohjelmointi.bookstore.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import palvelinohjelmointi.bookstore.models.Book;
import palvelinohjelmointi.bookstore.repositories.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/booklist")
	public String index(Model model) {
		List<Book> books = (List<Book>) bookRepository.findAll();
		model.addAttribute("books", books);
		return "booklist";
	}
	
	@GetMapping("/addbook")
	public String addbook() {
		
		return "addbook";
	}
	
	@PostMapping("/addbook")
	public String addbookForm(@ModelAttribute Book book) {
		this.bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	@GetMapping("/{id}")
	public String deleteOne(@PathVariable Long id) {
		bookRepository.deleteById(id);
		return "redirect:/booklist";
	}
	
	@GetMapping("/editbook/{id}")
	public String editOne(Model model, @PathVariable Long id) {
		Optional<Book> book = bookRepository.findById(id);
		model.addAttribute("book", book);
		return "editbook";
	}
	
	@GetMapping("/editbook/edit/{id}")
	public String editOneById(@PathVariable Long id, @ModelAttribute Book book) {
		bookRepository.deleteById(id);
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
}
