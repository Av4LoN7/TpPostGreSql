package fr.diginamic.postgres.postGresSql.dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import fr.diginamic.postgres.postGresSql.Book;

public class BookDAO {
	
	
	/**
	 * Insert one or multiple book
	 * @param book
	 * @param url
	 */
	public void insertBook(String url, Book book) {
		String query = "INSERT INTO book(title, author) VALUES(?,?)";
		try(Connection conn = DriverManager.getConnection(url, "postgres", "allmighty974")){
			
			try(PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
					stmt.setString(1, book.getTitle());
					stmt.setString(2, book.getAuthor());
					stmt.execute();
					ResultSet resultKey = stmt.getGeneratedKeys();
					resultKey.next();
					book.setId_book(resultKey.getLong("id_book"));
			
			} catch(Exception e1) {
				e1.printStackTrace();
				System.out.println(e1.getMessage());
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Insert multiple book
	 * @param books
	 * @param url
	 */
	/*public void insertBookData(List<Book> books, String url) {
		String query = "INSERT INTO book(title, author) VALUES(?,?)";
		
		try(Connection conn = DriverManager.getConnection(url, "postgres", "allmighty974")){
			conn.setAutoCommit(false);
			
			try(PreparedStatement stmt = conn.prepareStatement(query)){			
				for(Book book : books) {
					stmt.setString(1, book.getTitle());
					stmt.setString(2, book.getAuthor());
					stmt.execute();
				}
				conn.commit();			
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				conn.rollback();
			} finally {
				conn.setAutoCommit(true);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}	
	}*/
	
	
	/**
	 * Get all book from database
	 * @param url
	 * @return
	 */
	/*public Collection<Book> getAllBooks(String url) {
		String query = "SELECT * FROM book";
		Collection<Book> bookStore = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, "postgres", "allmighty974")) {
			try(PreparedStatement stmt = conn.prepareStatement(query)){
				ResultSet result = stmt.executeQuery();
				while(result.next()) {
					bookStore.add(new Book(result.getString("title"), result.getString("author"), result.getInt("id_book")));
				}
			} catch(Exception e1) {
				System.out.println(e1.getMessage());
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookStore;
	}
	
	
	/**
	 * get one book from database by id
	 * @param url
	 * @param id
	 * @return
	 */
	/*public Book getABook(String url, int id) {
		String query = "SELECT * FROM book WHERE id_book = ?";
		Book bookTemp = null;
		try(Connection conn = DriverManager.getConnection(url, "postgres", "allmighty974")) {
			try(PreparedStatement stmt = conn.prepareStatement(query)){
				stmt.setInt(1, id);
				ResultSet result = stmt.executeQuery();
				while(result.next()) {
					bookTemp = new Book(result.getString("title"), result.getString("author"), result.getInt("id_book"));
				}
			} catch(Exception e1) {
				System.out.println(e1.getMessage());
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookTemp;
	}*/
	

}
