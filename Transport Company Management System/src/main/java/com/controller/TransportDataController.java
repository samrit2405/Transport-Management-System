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
import com.bo.TransportInfo;
import com.dao.ConnectionDao;

/**
 * Servlet implementation class TransportDataController
 */
@WebServlet("/TransportDataController")
public class TransportDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransportDataController() {
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
			List<TransportInfo> list=ConnectionDao.getTransportInfo();
			
			pw.print("<table border='1px solid black'; width='100%'>");
			pw.print("<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>");
			pw.print("<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">");
			
			pw.print("<tr> <th>D_Id  </th> <th>Vehicle-No </th> <th> Phone </th> <th> Product</th> <th> Shipping-addr </th> <th>Edit</th> <th>Delete</th> </tr>");

			for(TransportInfo ti: list)
			{
				pw.print("<tr><td>"+ti.getD_id()+"</td><td>"+ti.getVehicle_No()+"</td><td>"+ti.getPhone()+"</td><td>"
				+ti.getProduct()+"</td><td>"+ti.getShipping_addr()+"</td><td>"+"<a href='EditServlet1?D_id="+ti.getD_id()+"'> <i class='fas fa-edit' style='font-size:15px;color:blue'></i> </a> </td> <td><a href='DeleteServlet1?D_id="+ti.getD_id()+"'><i class=\"material-icons\" style=\"font-size:20px;color:white\">&#xe872;</i></a></td></tr>");   
			}
			 pw.print("</table>");
		}

		
	}

	


