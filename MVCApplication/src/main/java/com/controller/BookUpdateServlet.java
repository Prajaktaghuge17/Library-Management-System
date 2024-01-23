package com.controller;

import com.bean.*;
import com.dao.*;
import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class BookUpdateServlet extends HttpServlet 
{
    public BookUpdateServlet() 
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
	  String title=request.getParameter("title");
	  String author=request.getParameter("author");
	  String price=request.getParameter("price");
	  String quantity=request.getParameter("quantity");
	
	  
	  PrintWriter out= response.getWriter();
	  BookupdateBean bbuobj= new BookupdateBean();
	 
	  bbuobj.setTitle(title);
	  bbuobj.setAuthor(author);
	  bbuobj.setPrice(price);
	  bbuobj.setQuantity(quantity);
	  bbuobj.setId(id);
	 
	  RequestDispatcher rd1= request.getRequestDispatcher("./updatebook.jsp");
	  RequestDispatcher rd2= request.getRequestDispatcher("./updatebookform.html");
	  
	  Bookupdatedao bduobj= new Bookupdatedao();
	  try 
	  {
		String str=bduobj.userAuthentication(bbuobj);
		
		 if(str.equals("Record updated successfully"))
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