package palvelinohjelmointi.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import palvelinohjelmointi.bookstore.controllers.BookController;
import palvelinohjelmointi.bookstore.controllers.RestBookController;
import palvelinohjelmointi.bookstore.models.Book;
import palvelinohjelmointi.bookstore.models.Category;
import palvelinohjelmointi.bookstore.models.User;
import palvelinohjelmointi.bookstore.repositories.BookRepository;
import palvelinohjelmointi.bookstore.repositories.CategoryRepository;
import palvelinohjelmointi.bookstore.repositories.UserRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;
	
	@Autowired
	private RestBookController restController;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	void contextLoadsBookController() throws Exception {
		assertThat(bookController).isNotNull();
	}
	
	@Test
	void contextLoadsRestController() throws Exception {
		assertThat(restController).isNotNull();
	}
	
	// Testataan userRepository
	@Test
	public void findByUsernameReturnsUser() {
		User user = userRepository.findByUsername("user");
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void createNewUserToRepository() {
		User user = new User("test", "test", "test", "test");
		userRepository.save(user);
		assertThat(userRepository.findByUsername("test").getUsername()).contains("test");
	}
	
	@Test
	public void deleteUserFromUserRepository() {
		User user = new User("test", "test", "test", "test");
		userRepository.save(user);
		userRepository.delete(user);
		assertThat(userRepository.findByUsername("test")).isNull();
	}
	
	// Testataan categoryRepository
	
	@Test
	public void findByCategoryName() {
		Category category = categoryRepository.findByName("seikkailu");
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	@Test
	public void createNewCategoryCreatesNewCategory() {
		Category category = new Category("Draama");
		categoryRepository.save(category);
		assertThat(categoryRepository.findByName("Draama")).isNotNull();
	}
	
	@Test
	public void deleteFromCategoryRepository() {
		Category category = new Category("Draama");
		categoryRepository.save(category);
		categoryRepository.delete(category);
		assertThat(categoryRepository.findByName("Draama")).isNull();
	}
	
	@Test
	public void findBookByAuthorReturnsOneBook() {
		List<Book> books = bookRepository.findByAuthor("Lassie");
		assertThat(books).hasSize(1);
	}
	
	@Test
	public void createNewBookToBookRepository() {
		Book book = new Book("Seikkailija", "Testaaja", "100", 1990, 33);
		bookRepository.save(book);
		List<Book> books = bookRepository.findByAuthor("Testaaja");
		assertThat(books).hasSize(1);
	}
	
	
}





























