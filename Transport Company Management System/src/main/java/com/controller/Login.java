package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Signupdata;
import com.dao.ConnectionDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		String email=request.getParameter("email");
		String pwd=request.getParameter("password");
		String C_pwd=request.getParameter("Confirm_password");
		
		boolean status=false;
		
		 status=ConnectionDao.loginValidate(email, pwd, C_pwd);
		
		if(status)
		{
			pw.print("<script>alert('You have sucessfully signed up')</script)");
			RequestDispatcher rd=request.getRequestDispatcher("about.html");
			rd.forward(request, response);
		}
		else
		{
			pw.print("<script>alert('Invalid user or password')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

}
