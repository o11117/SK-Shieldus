package com.rookies4.myspringbootlab.repository;

import com.rookies4.myspringbootlab.entity.Book;
import org.hibernate.annotations.DynamicUpdate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@DynamicUpdate
//@RequiredArgsConstructor
public class BookRepositoryTest {

//    private final BookRepository bookRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Rollback(value = false)
    public void testCreateBook(){

        Book book = new Book();
        book.setTitle("스프링 부트 입문");
        book.setAuthor("홍길동");
        book.setIsbn("9788956746425");
        book.setPrice(30000);
        book.setPublishDate(LocalDate.parse("2025-05-07"));

        Book savedBook = bookRepository.save(book);
        System.out.println("savedBook = " + savedBook);
    }

    @Test
    public void testFindByIsbn() {

        Optional<Book> bookByIsbn = bookRepository.findByIsbn("9788956746425");
        if(bookByIsbn.isPresent()){
        Book existingBook = bookByIsbn.get();
        assertThat(existingBook.getIsbn()).isEqualTo("9788956746425");
        }
    }
    
    @Test
    public void testFindByAuthor() {
        List<Book> booksByAuthor = bookRepository.findByAuthor("홍길동");
        if(booksByAuthor.isEmpty()){
            System.out.println("No books found for the author.");
        }
        assertThat(booksByAuthor).isNotEmpty();
        for (Book book : booksByAuthor) {
            System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
        }

    }

}
