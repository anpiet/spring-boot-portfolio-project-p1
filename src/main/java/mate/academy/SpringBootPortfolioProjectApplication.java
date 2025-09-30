package mate.academy;

import java.math.BigDecimal;
import mate.academy.model.Book;
import mate.academy.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootPortfolioProjectApplication {

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPortfolioProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Book book1 = new Book();
                book1.setTitle("Book 1");
                book1.setAuthor("Author 1");
                book1.setId(1L);
                book1.setPrice(BigDecimal.valueOf(345.23));
                book1.setIsbn("ISBN 1");
                book1.setDescription("Description 1");
                book1.setCoverImage("Cover 1");

                bookRepository.save(book1);
                System.out.println(bookRepository.findAll());

            }
        };
    }
}
