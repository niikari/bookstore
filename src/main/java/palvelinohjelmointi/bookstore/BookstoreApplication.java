package palvelinohjelmointi.bookstore;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import palvelinohjelmointi.bookstore.models.Book;
import palvelinohjelmointi.bookstore.models.Category;
import palvelinohjelmointi.bookstore.models.User;
import palvelinohjelmointi.bookstore.repositories.BookRepository;
import palvelinohjelmointi.bookstore.repositories.CategoryRepository;
import palvelinohjelmointi.bookstore.repositories.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner book(BookRepository repository, CategoryRepository categoryRepository, UserRepository userRepository) {
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
			BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
			User user1 = new User("user", crypt.encode("user"), "user@gmail.com", "USER");
			User user2 = new User("admin", crypt.encode("admin"), "admin@hotmail.com", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
		};
	}
}
