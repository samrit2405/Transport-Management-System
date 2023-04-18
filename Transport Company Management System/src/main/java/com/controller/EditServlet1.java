package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.DriverInfo;
import com.bo.TransportInfo;
import com.dao.ConnectionDao;

/**
 * Servlet implementation class EditServlet1
 */
@WebServlet("/EditServlet1")
public class EditServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 response.setContentType("text/html");
		   PrintWriter pw=response.getWriter();
		   
		   int D_id= Integer.parseInt(request.getParameter("D_id"));
		  
		  TransportInfo ti=ConnectionDao.getInfobyD_id(D_id);
		  
		  pw.print("<form  action='T_updatecontroller' method='get'> ");
		  pw.print("<link rel=\"stylesheet\" href=\"style2.css\">");
		    
			
		 
		  pw.print(" <div class='cs'> <table>");
			pw.print(" <h1>Enter Update</h1>");
			
			pw.print("<tr><td>Driver_id</td><td><input type='text' name='D_id' value='"+ti.getD_id()+"'/></td></tr>");  
			pw.print("<tr><td>Phone: </td> <td><input type='text' name='Phone' value='"+ti.getPhone()+"'/></td></tr>");
			pw.print("<tr><td>Vehicle-details: </td> <td><input type='text' name='Vehicle_No' value='"+ti.getVehicle_No()+"'/></td></tr>");
		   	pw.print("<tr><td>Product-details: </td> <td><input type='text' name='product' value='"+ti.getProduct()+"'/></td></tr>");
		   	pw.print("<tr><td>Shipping-addr:</td> <td><input type='text' name='shipping_addr' value='"+ti.getShipping_addr()+"'/></td></tr>");
		   	
		    pw.print("<tr><td><input type='submit' value='Update' /></td></tr>"); 
		    
		   	pw.print("</table> </div>");
		   	
			pw.print("</form>");
	
	}
	}

	


