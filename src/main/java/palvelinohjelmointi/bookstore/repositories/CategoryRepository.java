package palvelinohjelmointi.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;

import palvelinohjelmointi.bookstore.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
