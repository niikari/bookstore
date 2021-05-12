package palvelinohjelmointi.bookstore;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import palvelinohjelmointi.bookstore.models.Book;
import palvelinohjelmointi.bookstore.models.Category;
import palvelinohjelmointi.bookstore.repositories.BookRepository;
import palvelinohjelmointi.bookstore.repositories.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner studentDemo(BookRepository repository, CategoryRepository categoryRepository) {
		return (args) -> {
			Book book = new Book("Musta joutsen", "Arja Koriseva", "1234567-9", 1998, 213.50);			
			Book book2 = new Book("Kulkurin koiranpentu", "Lassie", "1285207-9", 1943, 2456.50);			
			Category category = new Category("seikkailu");
			Category category2 = new Category("toiminta");
			categoryRepository.save(category);
			categoryRepository.save(category2);
			book.setCategory(category);
			book2.setCategory(category2);
			repository.save(book);
			repository.save(book2);
		};
	}
}
