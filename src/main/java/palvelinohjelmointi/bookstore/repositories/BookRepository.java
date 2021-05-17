package palvelinohjelmointi.bookstore.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import palvelinohjelmointi.bookstore.models.Book;

@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByAuthor(@Param("author") String author);
}
