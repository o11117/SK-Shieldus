package mylab.book.entity;

public class Novel extends Publication {

    private String author;
    private String genre;

	public Novel() {
        super();
	}

    public Novel(String title, String publishDate, int page, int price, String author, String genre) {
        super(title, publishDate, page, price);
        this.author = author;
        this.genre = genre;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    @Override
    public String toString() {
        return "Novel [제목=" + getTitle() + ", 출판일=" + getPublishDate() + ", 페이지=" + getPage()
                + ", 가격=" + getPrice() + ", 저자명=" + author + ", 장르=" + genre + "]";
    }
}
