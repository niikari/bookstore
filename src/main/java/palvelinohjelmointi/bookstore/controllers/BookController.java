package palvelinohjelmointi.bookstore.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import palvelinohjelmointi.bookstore.models.Book;
import palvelinohjelmointi.bookstore.models.Category;
import palvelinohjelmointi.bookstore.repositories.BookRepository;
import palvelinohjelmointi.bookstore.repositories.CategoryRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/booklist")
	public String index(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}
	
	@GetMapping("/addbook")
	public String addbook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("category", new Category());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}
	
	@PostMapping("/addbook")
	public String addbookForm(@Validated Book book, BindingResult bd, Category category) {
		
		if (bd.hasErrors()) {
			return "redirect:/addbook";
		}
		
		book.setCategory(category);
		this.bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteOne(@PathVariable Long id) {
		bookRepository.deleteById(id);
		return "redirect:/booklist";
	}
	
	@GetMapping("/editbook/{id}")
	public String editOne(Model model, @PathVariable Long id) {
		Optional<Book> book = bookRepository.findById(id);
		model.addAttribute("category", new Category());
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("book", book);
		return "editbook";
	}
	
	@GetMapping("/editbook/edit/{id}")
	public String editOneById(@PathVariable Long id, @ModelAttribute Book book) {
		bookRepository.deleteById(id);
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("logout")
	public String logout() {
		
		return "logout";
	}
	
}
