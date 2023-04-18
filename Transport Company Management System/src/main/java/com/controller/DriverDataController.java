package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.DriverInfo;
import com.dao.ConnectionDao;

/**
 * Servlet implementation class DriverDataController
 */
@WebServlet("/DriverDataController")
public class DriverDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverDataController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
      response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		pw.print("<link rel=\"stylesheet\" href=\"style1.css\">");
		List<DriverInfo> list=ConnectionDao.getDiverInfo();
		
		pw.print("<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>");
		pw.print("<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">");
		
		pw.print("<table border='1px solid black'; width='100%'>");
		
		pw.print("<tr> <th>Id  </th> <th>Full_Name </th> <th> DOB </th> <th> Email </th> <th> Phone </th>"
				+ " <th>Driving_lic </th>   <th> Address </th>"
				+ " <th> City </th>  <th>state </th> <th> Pincode </th> <th>Edit</th> <th>Delete</th> </tr>");

		for(DriverInfo di: list)
		{
			pw.print("<tr><td>"+di.getId()+"</td><td>"+di.getFull_name()+"</td><td>"+di.getDob()+"</td><td>"
			+di.getEmail()+"</td><td>"+di.getPhone()+"</td><td>"+di.getDriving_lic()+"</td><td>"
			+di.getAddress()+"</td><td>"+di.getCity()+"</td><td>"+di.getState()+"</td><td>"+di.getPincode()+"</td><td>"+"<a href='EditServlet2?id="+di.getId()+"'> <i class='fas fa-edit' style='font-size:15px;color:blue'></i> </a> </td> <td><a href='DeleteServlet?id="+di.getId()+"'><i class=\"material-icons\" style=\"font-size:20px;color:white\">&#xe872;</i></a></td></tr>");   
		}
		 pw.print("</table>");
	}

	

}
