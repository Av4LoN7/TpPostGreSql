package fr.diginamic.postgres.postGresSql.dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import fr.diginamic.postgres.postGresSql.Book;
import fr.diginamic.postgres.postGresSql.Client;
import fr.diginamic.postgres.postGresSql.Gender;

public class ClientDAO {
	
	
	public void insertClient(String url, Client client) {
		String query = "INSERT INTO client(firstname, lastname, genre) VALUES(?,?,?)";
		try(Connection conn = DriverManager.getConnection(url, "postgres", "allmighty974")){	
			try(PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
					stmt.setString(1, client.getFirstName());
					stmt.setString(2, client.getLastName());
					stmt.setString(3, client.getGender().name());
					stmt.execute();
					ResultSet result = stmt.getGeneratedKeys();
					result.next();
					client.setId_client(result.getLong("id_client"));
								
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
	
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}	
	}
	
	public Collection<Book> getBookByClient(String url, Client client){
		Collection<Book> clientBook = new ArrayList<>();
		String query = "SELECT book.title, book.author, book.id_book FROM book JOIN achat ON book.id_book = achat.id_book JOIN client ON achat.id_client = client.id_client WHERE client.id_client = ?";
		try(Connection conn = DriverManager.getConnection(url, "postgres", "allmighty974")){
			conn.setAutoCommit(false);
			try(PreparedStatement stmt = conn.prepareStatement(query)){
					stmt.setLong(1, client.getId_client());
					ResultSet result = stmt.executeQuery();
					while(result.next()) {
						clientBook.add(new Book(result.getString("title"), result.getString("author"), result.getLong("id_book")));
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
		return clientBook;
		
	}
	
	//public void setFavorie(Client, int)
	
	
	/*public void insertClientData(List<Client> clients, String url) {
		String query = "INSERT INTO client(firstname, lastname, genre) VALUES(?,?, ?)";
		
		try(Connection conn = DriverManager.getConnection(url, "postgres", "allmighty974")){
			conn.setAutoCommit(false);
			
			try(PreparedStatement stmt = conn.prepareStatement(query)){			
				for(Client client : clients) {
					stmt.setString(1, client.getFirstName());
					stmt.setString(2, client.getLastName());
					stmt.setString(3, client.getGender() == Gender.MALE ? "1" : "2");
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
	
	/*public Client getAClient(String url, int id) {
		String query = "SELECT * FROM client WHERE id_client = ?";
		Client clientTemp = null;
		try(Connection conn = DriverManager.getConnection(url, "postgres", "allmighty974")) {
			try(PreparedStatement stmt = conn.prepareStatement(query)){
				stmt.setInt(1, id);
				ResultSet result = stmt.executeQuery();
				while(result.next()) {
					clientTemp = new Client( result.getString("firstname"), result.getString("lastname"), result.getString("genre"), result.getInt("id_client")  ));
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
