package com.bo;

public class TransportInfo {

	private int D_id;
	private String phone;
	private String Vehicle_No;
	private String Product;
	private String Shipping_addr;
	
	public int getD_id() {
		return D_id;
	}
	public void setD_id(int d_id) {
		D_id = d_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getVehicle_No() {
		return Vehicle_No;
	}
	public void setVehicle_No(String vehicle_No) {
		Vehicle_No = vehicle_No;
	}
	public String getProduct() {
		return Product;
	}
	public void setProduct(String product) {
		Product = product;
	}
	public String getShipping_addr() {
		return Shipping_addr;
	}
	public void setShipping_addr(String shipping_addr) {
		Shipping_addr = shipping_addr;
	}
	
	
	public TransportInfo( String phone, String vehicle_No, String product, String shipping_addr) {
		super();
		
		this.phone = phone;
		Vehicle_No = vehicle_No;
		Product = product;
		Shipping_addr = shipping_addr;
	}
	
	
	public TransportInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransportInfo(int d_id, String phone, String vehicle_No, String product, String shipping_addr) {
		super();
		D_id = d_id;
		this.phone = phone;
		Vehicle_No = vehicle_No;
		Product = product;
		Shipping_addr = shipping_addr;
	}
		
}
