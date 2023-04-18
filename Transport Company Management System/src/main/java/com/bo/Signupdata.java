package com.bo;

public class Signupdata {

	private String name;
	private String email;
	private String phone;
	private String password;
	private String C_password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getC_password() {
		return C_password;
	}
	public void setC_password(String c_password) {
		C_password = c_password;
	}
	
	
	public Signupdata(String name, String email, String phone, String password, String c_password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		C_password = c_password;
	}
	
	
	public Signupdata() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
