package com.controller;
import com.bean.*;
import com.dao.*;
import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class BookServlet extends HttpServlet 
{
    public BookServlet() 
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
	  BookBean bbobj= new BookBean();
	  bbobj.setId(id);
	  bbobj.setTitle(title);
	  bbobj.setAuthor(author);
	  bbobj.setPrice(price);
	  bbobj.setQuantity(quantity);
	  RequestDispatcher rd1= request.getRequestDispatcher("./book.jsp");
	  RequestDispatcher rd2= request.getRequestDispatcher("./addbookform.html");
	  
	  Bookdao bdobj= new Bookdao();
	  try 
	  {
		String str=bdobj.userAuthentication(bbobj);
		
		 if(str.equals("Record inserted successfully"))
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