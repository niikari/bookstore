package palvelinohjelmointi.bookstore.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import palvelinohjelmointi.bookstore.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByAuthor(String author);
}
