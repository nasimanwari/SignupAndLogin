package signupSystem.entities.concretes;

import signupSystem.entities.abstracts.Entity;

public class UserInfo implements Entity {
	private int id;
	private String name;
	private String lastName;
	private String email;
	private String passWord;
	private boolean verified;
	
	public UserInfo() {
		
	}

	public UserInfo(int id, String name, String lastName, String email, String passWord, boolean verified) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.passWord = passWord;
		this.verified = verified;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
