package com.rookies4.myspringbootlab.service;

import com.rookies4.myspringbootlab.controller.dto.BookDTO;
import com.rookies4.myspringbootlab.entity.Book;
import com.rookies4.myspringbootlab.exception.BusinessException;
import com.rookies4.myspringbootlab.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookService {
    private final BookRepository bookRepository;

    public List<BookDTO.BookResponse> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(BookDTO.BookResponse::fromEntity)
                .toList();
    }

    public BookDTO.BookResponse getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Book Not Found", HttpStatus.NOT_FOUND));
        return BookDTO.BookResponse.fromEntity(book);
    }

    public  BookDTO.BookResponse getBookByIsbn(String isbn) {
        Book book = bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new BusinessException("Book Not Found with" + isbn, HttpStatus.NOT_FOUND));
        return BookDTO.BookResponse.fromEntity(book);
    }

    public List<BookDTO.BookResponse> getBooksByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        return books.stream()
                .map(BookDTO.BookResponse::fromEntity)
                .toList();
    }

    @Transactional
    public BookDTO.BookResponse createBook(BookDTO.BookCreateRequest request){
        bookRepository.findByIsbn(request.getIsbn())
                .ifPresent(b -> {
                    throw new BusinessException("Book with ISBN already exists", HttpStatus.BAD_REQUEST);
                });

        Book book = request.toEntity();
        Book savedBook = bookRepository.save(book);
        return BookDTO.BookResponse.fromEntity(savedBook);
    }

    @Transactional
    public BookDTO.BookResponse updateBook(Long id, BookDTO.BookUpdateRequest request){
        Book existBook = bookRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Book Not Found", HttpStatus.NOT_FOUND));

        if (request.getTitle() != null) {
            existBook.setTitle(request.getTitle());
        }
        if (request.getAuthor() != null) {
            existBook.setAuthor(request.getAuthor());
        }
        if (request.getIsbn() != null) {
            existBook.setIsbn(request.getIsbn());
        }
        if (request.getPrice() != null) {
            existBook.setPrice(request.getPrice());
        }
        Book updatedBook = bookRepository.save(existBook);
        return BookDTO.BookResponse.fromEntity(updatedBook);
    }

    @Transactional
    public void deleteBook(Long id){
        Book existBook = bookRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Book Not Found", HttpStatus.NOT_FOUND));
        bookRepository.delete(existBook);
    }

}
