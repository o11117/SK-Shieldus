package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private String name;
	List<Book> books = new ArrayList<>();
	
	public Library(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public Book findBookByTitle(String Title) {
		
	}
	
	public List<Book> findBooksByAuthor(String author){
		
	}
}
