package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bo.DriverInfo;
import com.bo.Signupdata;
import com.bo.TransportInfo;

public class ConnectionDao {

	public static Connection getConnection()
	{
		Connection con=null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Transport_Management_System";
			String user="root";
			String pwd="2405";
			con=DriverManager.getConnection(url,user,pwd);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return con;
	}
	
	public static int insert(Signupdata ts)
	{
		int status=0;
		
		try {
		
			Connection con=ConnectionDao.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO signup(name,email,phone,password,C_password) VALUES(?,?,?,?,?)");
			
			ps.setString(1,ts.getName());
			ps.setString(2,ts.getEmail());
			ps.setString(3,ts.getPhone());
			ps.setString(4,ts.getPassword());
			ps.setString(5,ts.getC_password());
			
			status=ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static boolean loginValidate(String email,String pwd,String C_pwd)
	{
		boolean status=false;
		//System.out.println(pwd+" "+email+" "+C_pwd );
		
		try {
			
			Connection con=ConnectionDao.getConnection();
			
			PreparedStatement ps=con.prepareStatement("SELECT * from signup where email=? and password=? and C_password=?");
			ps.setString(1, email);
			ps.setString(2, pwd);
			ps.setString(3, C_pwd);
			
			ResultSet rs=ps.executeQuery();
			
			status=rs.next();
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		
		return status;
	}
	
	public static int insert_DriverInfo(DriverInfo dt)
	{
		
		int status=0;
		
		try {
			
              Connection con=ConnectionDao.getConnection();
			
			PreparedStatement ps=con.prepareStatement("INSERT INTO driver_info(full_name,dob,email,phone,driving_licence,address,city,state,pincode) VALUES(?,?,?,?,?,?,?,?,?)");
	
			ps.setString(1,dt.getFull_name());
			ps.setString(2,dt.getDob());
			ps.setString(3,dt.getEmail());
			ps.setString(4,dt.getPhone());
			ps.setString(5,dt.getDriving_lic());
			ps.setString(6,dt.getAddress());
			ps.setString(7,dt.getCity());
			ps.setString(8,dt.getState());
			ps.setString(9,dt.getPincode());
		
			status=ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	public static List getDiverInfo()
	{
		List<DriverInfo> list=new ArrayList<>();
		
		try {
			
			Connection con=ConnectionDao.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM driver_info");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				DriverInfo di=new DriverInfo();
				
				di.setId(rs.getInt(1));
				di.setFull_name(rs.getString(2));
				di.setDob(rs.getString(3));
				di.setEmail(rs.getString(4));
				di.setPhone(rs.getString(5));
				di.setDriving_lic(rs.getString(6));
				di.setAddress(rs.getString(7));
				di.setCity(rs.getString(8));
				di.setState(rs.getString(9));
				di.setPincode(rs.getString(10));
				
				list.add(di);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	public static int insert_TranportInfo(TransportInfo ti)
	{
		
		int status=0;
		
		try {
			
              Connection con=ConnectionDao.getConnection();
			
			PreparedStatement ps=con.prepareStatement("INSERT INTO transport_info(Vehicle_No,phone,product,shipping_addr) VALUES(?,?,?,?)");
	
			ps.setString(1,ti.getVehicle_No());
			ps.setString(2,ti.getPhone());
			ps.setString(3,ti.getProduct());
			ps.setString(4,ti.getShipping_addr());
		
			status=ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	public static List getTransportInfo()
	{
		List<TransportInfo> list=new ArrayList<>();
		
		try {
			
			Connection con=ConnectionDao.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM transport_info");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				TransportInfo ti=new TransportInfo();
				
				ti.setD_id(rs.getInt(1));
				ti.setPhone(rs.getString(2));
				ti.setVehicle_No(rs.getString(3));
				ti.setProduct(rs.getString(4));
				ti.setShipping_addr(rs.getString(5));
				
				list.add(ti);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	public static DriverInfo getInfo_byId(int id)
	{
		DriverInfo di=new DriverInfo();
		
		try {
			
			Connection con=ConnectionDao.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM driver_info where id=?");
			
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				di=new DriverInfo();
				di.setId(rs.getInt(1));
				di.setFull_name(rs.getString(2));
				di.setDob(rs.getString(3));
				di.setEmail(rs.getString(4));
				di.setPhone(rs.getString(5));
				di.setDriving_lic(rs.getString(6));
				di.setAddress(rs.getString(7));
				di.setCity(rs.getString(8));
				di.setState(rs.getString(9));
				di.setPincode(rs.getString(10));
			}
				
		} catch (Exception e) {
			System.out.println(e);
		}
		return di;
	}

	
	public static TransportInfo getInfobyD_id(int D_id)
	{
		TransportInfo ti=new TransportInfo();
		
		try {
			
			Connection con=ConnectionDao.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM transport_info where D_id=?");
			
			ps.setInt(1, D_id);;
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				ti=new TransportInfo();
				ti.setD_id(rs.getInt(1));
				ti.setPhone(rs.getString(2));;
				ti.setVehicle_No(rs.getString(3));
				ti.setProduct(rs.getString(4));
				ti.setShipping_addr(rs.getString(5));
				
			}
				
		} catch (Exception e) {
			System.out.println(e);
		}
		return ti;
	}

	public static int updateDriverData(DriverInfo di)
	{
		
		int status=0;
		
		try {
			
		Connection con=	ConnectionDao.getConnection();
		PreparedStatement ps=con.prepareStatement("UPDATE driver_info SET full_name=?,dob=?,email=?,phone=?,driving_licence=?,address=?,city=?,state=?,pincode=? WHERE id=?");
		
		ps.setString(1, di.getFull_name());
		ps.setString(2,di.getDob());
		ps.setString(3,di.getEmail());
		ps.setString(4,di.getPhone());
		ps.setString(5,di.getDriving_lic());
		ps.setString(6,di.getAddress());
		ps.setString(7,di.getCity());
		ps.setString(8,di.getState());
		ps.setString(9,di.getPincode());
		ps.setInt(10, di.getId());
		
		status=ps.executeUpdate();
		
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return status;
	}
	
	public static int deleteDriverData(int id)
	{
		
		int status=0;
		
		try {
			
			Connection con=ConnectionDao.getConnection();
			PreparedStatement ps=con.prepareStatement("DELETE FROM driver_info WHERE id=?");
			
			ps.setInt(1,id);
			
			status=ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static int updateTransportData(TransportInfo ti)
	{
		
		int status=0;
		
		try {
			
		Connection con=	ConnectionDao.getConnection();
		PreparedStatement ps=con.prepareStatement("UPDATE transport_info SET phone=?,Vehicle_No=?,product=?,shipping_addr=? WHERE D_id=?");
		
		ps.setString(1,ti.getPhone());
		ps.setString(2, ti.getVehicle_No());
		ps.setString(3,ti.getProduct());
		ps.setString(4,ti.getShipping_addr());
		ps.setInt(5,ti.getD_id());
		
		status=ps.executeUpdate();
		
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return status;
	}
	
	public static int deleteTransportData(int D_id)
	{
		
		int status=0;
		
		try {
			
			Connection con=ConnectionDao.getConnection();
			PreparedStatement ps=con.prepareStatement("DELETE FROM transport_info WHERE D_id=?");
			
			ps.setInt(1, D_id);;
			
			status=ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
