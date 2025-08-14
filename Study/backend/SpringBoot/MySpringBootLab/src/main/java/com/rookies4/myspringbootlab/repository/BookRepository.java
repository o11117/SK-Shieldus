package com.rookies4.myspringbootlab.repository;

import com.rookies4.myspringbootlab.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    //findByIsbn(String isbn) , findByAuthor(String author) 등의 메소드 정의 가능


    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findByAuthor(String author);
}
