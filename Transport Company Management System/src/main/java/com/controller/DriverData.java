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
 * Servlet implementation class DriverData
 */
@WebServlet("/DriverData")
public class DriverData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
         response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		String full_name=request.getParameter("name");
		String dob=request.getParameter("date");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String driving_lic =request.getParameter("DL");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String pincode=request.getParameter("pincode");
		
		DriverInfo dt=new DriverInfo (0,full_name,dob,email,phone,driving_lic,address,city,state, pincode);
		
		int status=ConnectionDao.insert_DriverInfo(dt);
		
		if(status>0)
		{
			pw.print("<script>alert('You have sucessfully inserted Driver information')</script)");
			RequestDispatcher rd=request.getRequestDispatcher("about.html");
			rd.forward(request, response);
		}
		else
		{
			pw.print("<script>alert('Sorry!!Something went wrong')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("Driver_details.html");
			rd.include(request, response);
		}
	}

}
