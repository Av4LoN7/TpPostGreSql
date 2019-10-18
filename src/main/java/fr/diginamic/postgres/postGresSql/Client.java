package fr.diginamic.postgres.postGresSql;

public class Client {
	
	private String lastName;
	private String firstName;
	private Gender gender;
	private Book favorie;
	private Long id;
	
	
	public Client(String lastName, String firstName, Gender gender) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
	}
	
	public Client(String lastName, String firstName, Gender gender, Long id) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
		this.id = id;
	}
	
	
	public Book getFavorie() {
		return favorie;
	}

	public void setFavorie(Book favorie) {
		this.favorie = favorie;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public Long getId_client() {
		return id;
	}

	public void setId_client(Long id_client) {
		this.id = id_client;
	}
	
	


}
