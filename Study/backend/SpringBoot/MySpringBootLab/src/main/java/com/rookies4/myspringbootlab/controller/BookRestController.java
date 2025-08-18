package com.rookies4.myspringbootlab.controller;

import com.rookies4.myspringbootlab.entity.Book;
import com.rookies4.myspringbootlab.exception.BusinessException;
import com.rookies4.myspringbootlab.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookRestController {
    private final BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn){

        Book existbook = bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new BusinessException("Book Not Found",
                org.springframework.http.HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(existbook);
    }
    @GetMapping("/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author){
        List<Book> books = bookRepository.findByAuthor(author);
        if (books.isEmpty()) {
            throw new BusinessException("No books found for the author: " + author,
                    org.springframework.http.HttpStatus.NOT_FOUND);
        }
        return books;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return ResponseEntity.ok(savedBook);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                    existingBook.setTitle(book.getTitle());
                    existingBook.setAuthor(book.getAuthor());
                    existingBook.setIsbn(book.getIsbn());
                    existingBook.setPrice(book.getPrice());
                    existingBook.setPublishDate(book.getPublishDate());
                    Book updatedBook = bookRepository.save(existingBook);
                    return ResponseEntity.ok(updatedBook);
                })
                .orElseThrow(() -> new BusinessException("Book Not Found",
                        org.springframework.http.HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookRepository.findById(id)
                .map(existingBook -> {
                    bookRepository.delete(existingBook);
                    return ResponseEntity.noContent().build();
                });
        return null;
    }
}