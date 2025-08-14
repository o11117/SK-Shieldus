package com.rookies4.myspringbootlab.repository;

import com.rookies4.myspringboot.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
//@RequiredArgsConstructor
public class BookRepositoryTest {

//    private final BookRepository bookRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testCreateBook(){
        Book book = new Book("스프링 부트 입문", "홍길동", "9788956746425", LocalDate.parse("2025-01-01"), 30000);

        Book save = bookRepository.save(book);
        System.out.println("save = " + save);
    }

    @Test
    public void testFindByIsbn() {
        Book book = new Book();

        Optional<Book> isbn = bookRepository.findByIsbn(book.getIsbn());

        System.out.println(isbn);
    }
}
