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
import com.bo.TransportInfo;
import com.dao.ConnectionDao;

/**
 * Servlet implementation class TransportDataController
 */
@WebServlet("/AddTransportData")
public class AddTransportData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTransportData() {
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
		
		//String id=request.getParameter("id"); 
		 // DriverInfo di=ConnectionDao.getInfo_byId(D_id);
		
		String VD=request.getParameter("Vehicle_No");
		String Phone=request.getParameter("Phone");
		String PD=request.getParameter("Product");
		String SA=request.getParameter("shipping_addr");
		
		TransportInfo ti=new TransportInfo(Phone, VD, PD, SA);
		
		int status=ConnectionDao.insert_TranportInfo(ti);
		
		if(status>0)
		{
			pw.print("<script>alert('You have sucessfully inserted Transportation details')</script)");
			RequestDispatcher rd=request.getRequestDispatcher("about.html");
			rd.forward(request, response);
		}
		else
		{
			pw.print("<script>alert('Sorry!!Something went wrong')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("Ts_details.html");
			rd.include(request, response);
		}
	
	
	}

}
