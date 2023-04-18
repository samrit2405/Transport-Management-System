package com.bo;

public class DriverInfo {

    private int id;
	private String full_name;
	private String dob;
	private String email;
	private String phone;
	private String driving_lic;
	private String address;
	private String city;
	private String state;
	private String pincode;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
	
	public String getDriving_lic() {
		return driving_lic;
	}
	public void setDriving_lic(String driving_lic) {
		this.driving_lic = driving_lic;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	public DriverInfo(int id,String full_name, String dob, String email, String phone, String driving_lic, String address,
			String city, String state, String pincode) {
		super();
		this.id=id;
		this.full_name = full_name;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.driving_lic = driving_lic;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public DriverInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
