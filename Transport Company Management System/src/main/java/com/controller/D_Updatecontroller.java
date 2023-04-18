package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.DriverInfo;
import com.dao.ConnectionDao;

/**
 * Servlet implementation class Updatecontroller
 */
@WebServlet("/D_Updatecontroller")
public class D_Updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D_Updatecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
		   PrintWriter pw=response.getWriter();
		   
		   int id=Integer.parseInt(request.getParameter("id"));
		   String full_name=request.getParameter("Full_name");
			String dob=request.getParameter("DOB");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			String driving_lic =request.getParameter("Driving_lic");
			String address=request.getParameter("address");
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			String pincode=request.getParameter("pincode");
			
			DriverInfo di=new DriverInfo(id,full_name,dob,email,phone,driving_lic,address,city,state, pincode);
				
			int status=ConnectionDao.updateDriverData(di);
			
			if(status>0)
			{
				pw.print("<script>alert('You have sucessfully updated Driver information')</script)");
				RequestDispatcher rd=request.getRequestDispatcher("DriverDataController");
				rd.forward(request, response);
			}
			
			else
			{
				pw.print("<script>alert('Sorry!!Something went wrong')</script>");
				RequestDispatcher rd=request.getRequestDispatcher("DriverDataController");
				rd.include(request, response);
			}
	}

	

}
