package fr.diginamic.postgres.postGresSql.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableDAO {
	
	public void createTable(String url) {
		try(Connection conn = DriverManager.getConnection(url, "postgres", "allmighty974")){
			conn.setAutoCommit(false);
			
			try(Statement stmt = conn.createStatement()){
				
				stmt.executeUpdate("DROP TABLE IF EXISTS achat");
				stmt.executeUpdate("DROP TABLE IF EXISTS client");
				stmt.executeUpdate("DROP TABLE IF EXISTS book");
				
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS book(id_book bigserial, title text, author text, "
						+ "CONSTRAINT pk_id_book PRIMARY KEY(id_book))");
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS client(id_client bigserial, lastname text NOT NULL, firstname text NOT NULL, favbook integer, genre varchar, "
						+ "CONSTRAINT pk_id_client PRIMARY KEY(id_client))");			
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS achat(id_client integer, id_book integer,"
						+ "CONSTRAINT fk_id_book FOREIGN KEY (id_book) REFERENCES book(id_book),"
						+ "CONSTRAINT fk_id_client FOREIGN KEY (id_client) REFERENCES client(id_client))");

				conn.commit();			
			} catch (Exception e) {
				e.printStackTrace();
				e.getMessage();
				conn.rollback();
			} finally {
				conn.setAutoCommit(true);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

}
