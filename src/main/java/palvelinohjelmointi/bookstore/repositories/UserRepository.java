package palvelinohjelmointi.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;

import palvelinohjelmointi.bookstore.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
