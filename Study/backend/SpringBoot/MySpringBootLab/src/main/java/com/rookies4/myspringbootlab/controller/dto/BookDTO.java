package com.rookies4.myspringbootlab.controller.dto;

import com.rookies4.myspringbootlab.entity.Book;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


public class BookDTO {

    @Getter
    @Setter
    public static class BookCreateRequest {
        @NotBlank(message = "Title은 필수 입력항목입니다.")
        private String title;

        @NotBlank(message = "Author은 필수 입력항목입니다.")
        private String author;

        @NotBlank(message = "ISBN은 필수 입력항목입니다.")
        private String isbn;

        @Positive(message = "Price은 양수여야합니다.")
        private Integer price;

        @NotBlank(message = "PublishDate은 필수 입력항목입니다.")
        private LocalDate publishDate;

        public Book toEntity() {
            Book book = new Book();
            book.setTitle(this.title);
            book.setAuthor(this.author);
            book.setIsbn(this.isbn);
            book.setPrice(this.price);
            book.setPublishDate(this.publishDate);
            return book;
        }
    }

    @Getter
    @Setter
    public static class BookUpdateRequest {
        private String title;
        private String author;
        private String isbn;

        @Positive(message = "Price은 양수여야합니다.")
        private Integer price;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class BookResponse {
        private Long id;
        private String title;
        private String author;
        private String isbn;
        private Integer price;
        private LocalDate publishDate;

        public static BookResponse fromEntity(Book book) {
            return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPrice(),
                book.getPublishDate()
            );
        }
    }
}
