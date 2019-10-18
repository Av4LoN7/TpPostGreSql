package fr.diginamic.postgres.postGresSql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.diginamic.postgres.postGresSql.dao.AchatDAO;
import fr.diginamic.postgres.postGresSql.dao.BookDAO;
import fr.diginamic.postgres.postGresSql.dao.ClientDAO;
import fr.diginamic.postgres.postGresSql.dao.TableDAO;

public class App 
{
    public static void main( String[] args )
    {
    	String url = "jdbc:postgresql://localhost:5432/tpJdbc";
    	
        /**
         *  creation des tables book, client, favorie et achat
         */
   
        TableDAO inst = new TableDAO();
        inst.createTable(url);
        
 
        /**
         * insert de book
         */
        List<Book> bookStore = new ArrayList<Book>();
        
        Book book1 = new Book("test", "woam");
        Book book2 = new Book("test1", "woam1");
        Book book3 = new Book("test2", "woam2");
        Book book4 = new Book("test3", "woam3");
        
        bookStore.add(book1);
        bookStore.add(book2);
        bookStore.add(book3);
        bookStore.add(book4);
        
        BookDAO bookDao = new BookDAO();
        bookDao.insertBook(url, book1);
        bookDao.insertBook(url, book2);
        bookDao.insertBook(url, book3);
        bookDao.insertBook(url, book4);
        
        
    	/**
    	 * insert client
    	 */
    	List<Client> clientList = new ArrayList<>();
    	Client client1 = new Client("Bob", "Dylan", Gender.MALE);
    	Client client2 = new Client("Boris", "Belloc", Gender.MALE);
    	Client client3 = new Client("Celia", "March", Gender.FEMALE);
    	Client client4 = new Client("Steve", "Rogers", Gender.MALE);
    	
    	clientList.add(client1);
    	clientList.add(client2);
    	clientList.add(client3);
    	clientList.add(client4);
    	
    	
    	ClientDAO cm = new ClientDAO();
    	cm.insertClient(url, client1);
    	cm.insertClient(url, client2);
    	cm.insertClient(url, client3);
    	cm.insertClient(url, client4);
    	
    	
    	/**
    	 * By a book or some books
    	 */
    	
    	AchatDAO achatDao = new AchatDAO();
    	achatDao.byABook(client1, book1, url);
    	achatDao.byABook(client2, book2, url);
    	achatDao.byABook(client3, book3, url);
    	achatDao.byABook(client4, book4, url);
    	achatDao.byABook(client2, book1, url);
    	
    	/**
    	 * Les Livres acheté par un certain client
    	 */
    	System.out.println(cm.getBookByClient(url, client1));
    	
    	
    	
    	
  
        
        
    }
}
