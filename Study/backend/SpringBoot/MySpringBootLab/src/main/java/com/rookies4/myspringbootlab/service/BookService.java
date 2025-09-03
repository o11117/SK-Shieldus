package com.rookies4.myspringbootlab.service;

import com.rookies4.myspringbootlab.controller.dto.BookDTO;
import com.rookies4.myspringbootlab.controller.dto.PublisherDTO;
import com.rookies4.myspringbootlab.entity.Book;
import com.rookies4.myspringbootlab.entity.BookDetail;
import com.rookies4.myspringbootlab.entity.Publisher;
import com.rookies4.myspringbootlab.exception.BusinessException;
import com.rookies4.myspringbootlab.exception.ErrorCode;
import com.rookies4.myspringbootlab.repository.BookRepository;
import com.rookies4.myspringbootlab.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public List<BookDTO.Response> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookDTO.Response::fromEntity)
                .toList();
    }

    public BookDTO.Response getBookById(Long id) {
        Book book = bookRepository.findByIdWithBookDetail(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.RESOURCE_NOT_FOUND, "Book", "id", id));

        BookDTO.Response response = BookDTO.Response.fromEntity(book);

        if (book.getPublisher() != null && response.getPublisher() != null) {
            Long publisherId = book.getPublisher().getId();
            Long bookCount = bookRepository.countByPublisherId(publisherId);

            PublisherDTO.SimpleResponse publisherWithCount =
                    PublisherDTO.SimpleResponse.fromEntityWithCount(
                            book.getPublisher(), bookCount);

            response.setPublisher(publisherWithCount);
        }

        return response;
    }

    public BookDTO.Response getBookByIsbn(String isbn) {
        Book book = bookRepository.findByIsbnWithBookDetail(isbn)
                .orElseThrow(() -> new BusinessException(ErrorCode.RESOURCE_NOT_FOUND, "Book", "ISBN", isbn));

        BookDTO.Response response = BookDTO.Response.fromEntity(book);

        if (book.getPublisher() != null && response.getPublisher() != null) {
            Long publisherId = book.getPublisher().getId();
            Long bookCount = bookRepository.countByPublisherId(publisherId);

            PublisherDTO.SimpleResponse publisherWithCount =
                    PublisherDTO.SimpleResponse.fromEntityWithCount(
                            book.getPublisher(), bookCount);

            response.setPublisher(publisherWithCount);
        }

        return response;
    }

    public List<BookDTO.Response> getBooksByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author)
                .stream()
                .map(BookDTO.Response::fromEntity)
                .toList();
    }

    public List<BookDTO.Response> getBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(BookDTO.Response::fromEntity)
                .toList();
    }


    public List<BookDTO.Response> getBooksByPublisherId(Long publisherId) {
        // Validate publisher exists
        if (!publisherRepository.existsById(publisherId)) {
            throw new BusinessException(ErrorCode.RESOURCE_NOT_FOUND,
                    "Publisher", "id", publisherId);
        }

        return bookRepository.findByPublisherId(publisherId)
                .stream()
                .map(BookDTO.Response::fromEntity)
                .toList();
    }

    @Transactional
    public BookDTO.Response createBook(BookDTO.Request request) {
        Publisher publisher = publisherRepository.findById(request.getPublisherId())
                .orElseThrow(() -> new BusinessException(ErrorCode.RESOURCE_NOT_FOUND,
                        "Publisher", "id", request.getPublisherId()));

        if (bookRepository.existsByIsbn(request.getIsbn())) {
            throw new BusinessException(ErrorCode.ISBN_DUPLICATE, request.getIsbn());
        }

        Book book = Book.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .price(request.getPrice())
                .publishDate(request.getPublishDate())
                .publisher(publisher)
                .build();

        if (request.getDetailRequest() != null) {
        // Create book detail if provided
        if (request.getDetail() != null) {
            BookDetail bookDetail = BookDetail.builder()
                    .language(request.getDetailRequest().getLanguage())
                    .description(request.getDetail().getDescription())
                    .language(request.getDetail().getLanguage())
                    .pageCount(request.getDetail().getPageCount())
                    .publisher(request.getDetail().getPublisher())
                    .coverImageUrl(request.getDetail().getCoverImageUrl())
                    .edition(request.getDetail().getEdition())
                    .book(book)
                    .build();

            book.setBookDetail(bookDetail);
        }

        // Save and return the book
        Book savedBook = bookRepository.save(book);
        return BookDTO.Response.fromEntity(savedBook);
    }

    @Transactional
    public BookDTO.Response updateBook(Long id, BookDTO.Request request) {
        // Find the book
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.RESOURCE_NOT_FOUND, "Book", "id", id));

        // Validate publisher exists (if changing)
        Publisher publisher = publisherRepository.findById(request.getPublisherId())
                .orElseThrow(() -> new BusinessException(ErrorCode.RESOURCE_NOT_FOUND,
                        "Publisher", "id", request.getPublisherId()));
        // Check if another book already has the ISBN
        if (!book.getIsbn().equals(request.getIsbn()) &&
                bookRepository.existsByIsbn(request.getIsbn())) {
            throw new BusinessException(ErrorCode.ISBN_DUPLICATE, request.getIsbn());
        }

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        book.setPrice(request.getPrice());
        book.setPublishDate(request.getPublishDate());
        book.setPublisher(publisher);

            BookDetail bookDetail = book.getBookDetail();


        // Update book detail if provided
        if (request.getDetail() != null) {
            BookDetail bookDetail = book.getBookDetail();

            // Create new detail if not exists
            if (bookDetail == null) {
                bookDetail = new BookDetail();
                bookDetail.setBook(book);
                book.setBookDetail(bookDetail);
            }

            // Update detail fields
            bookDetail.setDescription(request.getDetail().getDescription());
            bookDetail.setLanguage(request.getDetail().getLanguage());
            bookDetail.setPageCount(request.getDetail().getPageCount());
            bookDetail.setPublisher(request.getDetail().getPublisher());
            bookDetail.setCoverImageUrl(request.getDetail().getCoverImageUrl());
            bookDetail.setEdition(request.getDetail().getEdition());
        }

        // Save and return updated book
        Book updatedBook = bookRepository.save(book);
        return BookDTO.Response.fromEntity(updatedBook);
    }

    @Transactional
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BusinessException(ErrorCode.RESOURCE_NOT_FOUND, "Book", "id", id);
        }
        bookRepository.deleteById(id);
    }
}