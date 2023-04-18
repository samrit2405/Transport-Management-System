package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.DriverInfo;
import com.dao.ConnectionDao;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
          response.setContentType("text/html");
		   PrintWriter pw=response.getWriter();
		   
		  // String id=request.getParameter("id");
		  int D_id= Integer.parseInt(request.getParameter("id"));
		  
		  DriverInfo di=ConnectionDao.getInfo_byId(D_id);
		  
		  pw.print("<form  action='D_Updatecontroller' method='get'> ");
		  pw.print("<link rel=\"stylesheet\" href=\"style2.css\">");
		    
		  pw.print(" <div class='cs'> <table>");
			pw.print(" <h1>Enter Update</h1>");
			
			pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+di.getId()+"'/></td></tr>");  
			pw.print("<tr><td>Full_Name: </td> <td><input type='text' name='Full_name' value='"+di.getFull_name()+"'/></td></tr>");
			pw.print("<tr><td>Date of Birth: </td> <td><input type='date' name='DOB' value='"+di.getDob()+"'/></td></tr>");
		   	pw.print("<tr><td>Email: </td> <td><input type='text' name='email' value='"+di.getEmail()+"'/></td></tr>");
		   	pw.print("<tr><td>Phone:</td> <td><input type='text' name='phone' value='"+di.getPhone()+"'/></td></tr>");
		   	pw.print("<tr><td>Driving_licence: </td> <td><input type='text' name='Driving_lic' value='"+di.getDriving_lic()+"'/></td></tr>");
		   	pw.print("<tr><td>Address: </td> <td><input type='text' name='address' value='"+di.getAddress()+"'/></td></tr>");
		   	pw.print("<tr><td>City: </td> <td><input type='text' name='city' value='"+di.getCity()+"'/></td></tr>");
		   	pw.print("<tr><td>State:</td> <td><input type='text' name='state' value='"+di.getState()+"'/></td></tr>");
		   	pw.print("<tr><td>Pincode: </td> <td><input type='text' name='pincode' value='"+di.getPincode()+"'/></td></tr>");
		    pw.print("<tr><td><input type='submit' value='Update'/></td></tr>"); 
		    
		   	pw.print("</table></div>");
			
			pw.print("</form>");
	
	}
	
}
