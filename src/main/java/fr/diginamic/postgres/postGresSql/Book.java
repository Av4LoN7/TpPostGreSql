package fr.diginamic.postgres.postGresSql;

public class Book {
	
	private String title;
	private String author;
	private Long id_book;
	
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	
	public Book(String title, String author, Long id) {
		super();
		this.title = title;
		this.author = author;
		this.id_book = id;
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

	public Long getId_book() {
		return id_book;
	}

	public void setId_book(Long id_book) {
		this.id_book = id_book;
	}
	
	
	
	
	
	

}
