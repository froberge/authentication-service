package com.thecat.authentication.model;


public class User {
    private String name;
	private String password;
	private String email;
	private String gender;
	private String age;

	
    /**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param username the username to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmailAdr(String email) {
		this.email = email;
	}

	/** 
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
	
    public String toString() {
    	
    	StringBuffer sb = new StringBuffer( "Information on the user: \n" );
    	
    	sb.append("name [ " + this.name + "]\n");
    	sb.append("gender [ " + this.gender + "]\n");
    	sb.append("birthDate [ " + this.age + "]\n");
    	sb.append("email [ " + this.email + "]\n");
		sb.append("password [ " + this.password + "]\n");
    	
    	return sb.toString();
     }
}
