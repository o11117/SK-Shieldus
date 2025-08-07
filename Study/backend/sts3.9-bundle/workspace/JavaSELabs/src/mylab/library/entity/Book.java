package mylab.library.entity;

public class Book extends Library {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;
	
	public Book() {
	}

	public Book(String title, String author, String isbn, int publishYear) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
	
	public boolean checkOut() {
		
	}
	
	public void returnBook() {
		
	}
	
	public String toString() {
		
	}

	
	
	
}
