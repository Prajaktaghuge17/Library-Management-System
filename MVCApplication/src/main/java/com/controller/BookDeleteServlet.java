package com.controller;


import com.bean.*;
import com.dao.*;
import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class BookDeleteServlet extends HttpServlet 
{
    public BookDeleteServlet() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  String id=request.getParameter("id");
	 
	
	  
	  PrintWriter out= response.getWriter();
	  Bookdeletebean bbdobj= new Bookdeletebean();
	  bbdobj.setId(id);
	  
	  RequestDispatcher rd1= request.getRequestDispatcher("./deletebook.jsp");
	  RequestDispatcher rd2= request.getRequestDispatcher("./deletebookform.html");
	  
	  Bookdeletedao bbdobj2= new Bookdeletedao();
	  try 
	  {
		String str=bbdobj2.userAuthentication(bbdobj);
		
		 if(str.equals("Record delete successfully"))
		 {
			 rd1.forward(request, response);
		 }
		 else
		 {
			 out.print(""+str);
			 rd2.include(request, response);
		 }
	  }
	  catch (ClassNotFoundException | SQLException e) 
	  {
		e.printStackTrace();
	  }
	}
}//end Servlet class