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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		   PrintWriter pw=response.getWriter();
		   
		   int D_id= Integer.parseInt(request.getParameter("id"));
			  
			  int status=ConnectionDao.deleteDriverData(D_id);
			  
			  
				  if(status>0)
					{
						pw.print("<script>alert('You have sucessfully deleted Driver information')</script)");
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
