package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private String name;
	private List<Book> books = new ArrayList<>();
	
	
	public Library(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addBook(Book book) {
		books.add(book);
		System.out.println(" 도서가 추가되었습니다: " + book.getTitle());
	}
	
	public Book findBookByTitle(String title) {
		for (Book book: books) {
			if (book.getTitle().equals(title)) {
				return book;
			}
		}
		return null;
	}
	
	public List<Book> findBooksByAuthor(String author){
		List<Book> result = new ArrayList<>();
		
		for (Book book:books) {
			if (book.getAuthor().equals(author)) {
				result.add(book);
			}
		}
		return result;
	}
	
	public Book findBookByISBN(String isbn) {
		for (Book book: books) {
			if (book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}
	
	public boolean checkOutBook(String isbn) {
		Book book = findBookByISBN(isbn);
		return book.checkOut();
	}
	
	public boolean returnBook(String isbn) {
		Book book = findBookByISBN(isbn);
		book.returnBook();
		
		return true;
	}
	
	public List<Book> getAvailableBooks(){
		List<Book> result = new ArrayList<>();
		
		for(Book book:books) {
			if (book.isAvailable() == true) {
				result.add(book);
			}
		}
		return result;
	}
	
	public List<Book> getAllBooks(){
		return new ArrayList<>(books);
	}
	
	public int getTotalBooks() {
		return books.size();
	}
	
	public int getAvailableBooksCount() {
		
		int count = 0;
		for (Book book:books) {
			if (book.isAvailable() == true) {
				count++;
			}
		}
		return count;
	}
	
	public int getBorrowedBooksCount() {
		int count = 0;
		for (Book book:books) {
			if (book.isAvailable() == false) {
				count++;
			}
		}
		return count;
	}
}
