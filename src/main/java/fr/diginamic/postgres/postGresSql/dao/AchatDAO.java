package fr.diginamic.postgres.postGresSql.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.diginamic.postgres.postGresSql.Book;
import fr.diginamic.postgres.postGresSql.Client;

public class AchatDAO {
	
	public void byABook(Client client, Book book, String url) {
		
		String state = "INSERT INTO achat(id_book, id_client) VALUES(?,?)";
		
		try(Connection conn = DriverManager.getConnection(url, "postgres", "allmighty974")) {
			
			try (PreparedStatement stmt = conn.prepareStatement(state)){
				stmt.setLong(1, client.getId_client());
				stmt.setLong(2, book.getId_book());	
				stmt.execute();
							
			} catch(Exception e1) {
				System.out.println(e1.getMessage());	
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
