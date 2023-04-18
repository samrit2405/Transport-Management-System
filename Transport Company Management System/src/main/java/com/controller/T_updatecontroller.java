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
 * Servlet implementation class T_updatecontroller
 */
@WebServlet("/T_updatecontroller")
public class T_updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public T_updatecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		   PrintWriter pw=response.getWriter();
		   
		   int D_id=Integer.parseInt(request.getParameter("D_id"));
		   String VD=request.getParameter("Vehicle_No");
		   String phone=request.getParameter("Phone");
		    String PD=request.getParameter("product");
		    String SA =request.getParameter("shipping_addr");
			
		    TransportInfo ti=new TransportInfo(D_id,phone,VD,PD,SA);
				
			int status=ConnectionDao.updateTransportData(ti);
			
			if(status>0)
			{
				pw.print("<script>alert('You have sucessfully updated Transportation data')</script)");
				RequestDispatcher rd=request.getRequestDispatcher("TransportDataController");
				rd.forward(request, response);
			}
			
			else
			{
				pw.print("<script>alert('Sorry!!Something went wrong')</script>");
				RequestDispatcher rd=request.getRequestDispatcher("TransportDataController");
				rd.include(request, response);
			}
		
	}


}
