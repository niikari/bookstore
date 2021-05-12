package palvelinohjelmointi.bookstore;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import palvelinohjelmointi.bookstore.models.Book;
import palvelinohjelmointi.bookstore.repositories.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner studentDemo(BookRepository repository) {
		return (args) -> {
			Book book = new Book("Musta joutsen", "Arja Koriseva", "1234567-9", 1998, 213.50);
			repository.save(book);
			Book book2 = new Book("Kulkurin koiranpentu", "Lassie", "1285207-9", 1943, 2456.50);
			repository.save(book2);
			

		};
	}
}
